package pl.piomin.services.quarkus.employee.lifecycle;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.health.ServiceHealth;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class EmployeeLifecycle {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmployeeLifecycle.class);
	private String instanceId;

	@Inject
	Consul consulClient;
	@ConfigProperty(name = "quarkus.application.name")
	String appName;
	@ConfigProperty(name = "quarkus.application.version")
	String appVersion;

	void onStart(@Observes StartupEvent ev) {
		ScheduledExecutorService executorService = Executors
				.newSingleThreadScheduledExecutor();
		executorService.schedule(() -> {
			HealthClient healthClient = consulClient.healthClient();
			List<ServiceHealth> instances = healthClient
					.getHealthyServiceInstances(appName).getResponse();
			instanceId = appName + "-" + instances.size();
			int port = Integer.parseInt(System.getProperty("quarkus.http.port"));
			ImmutableRegistration registration = ImmutableRegistration.builder()
					.id(instanceId)
					.name(appName)
					.address("127.0.0.1")
					.port(port)
					.putMeta("version", appVersion)
					.build();
			consulClient.agentClient().register(registration);
			LOGGER.info("Instance registered: id={}, address=127.0.0.1:{}",
					registration.getId(), port);
		}, 5000, TimeUnit.MILLISECONDS);
	}

	void onStop(@Observes ShutdownEvent ev) {
		if(instanceId != null)
			consulClient.agentClient().deregister(instanceId);
		LOGGER.info("Instance de-registered: id={}", instanceId);
	}

}

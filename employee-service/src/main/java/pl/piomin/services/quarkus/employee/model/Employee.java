package pl.piomin.services.quarkus.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private Long organizationId;
	@NotNull
	private Long departmentId;
	@NotBlank
	private String name;
	@Min(1)
	@Max(100)
	private int age;
	@NotBlank
	private String position;

	public Long getId() {
		return this.id;
	}

	public @NotNull Long getOrganizationId() {
		return this.organizationId;
	}

	public @NotNull Long getDepartmentId() {
		return this.departmentId;
	}

	public @NotBlank String getName() {
		return this.name;
	}

	public @Min(1) @Max(100) int getAge() {
		return this.age;
	}

	public @NotBlank String getPosition() {
		return this.position;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrganizationId(@NotNull Long organizationId) {
		this.organizationId = organizationId;
	}

	public void setDepartmentId(@NotNull Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setName(@NotBlank String name) {
		this.name = name;
	}

	public void setAge(@Min(1) @Max(100) int age) {
		this.age = age;
	}

	public void setPosition(@NotBlank String position) {
		this.position = position;
	}
}

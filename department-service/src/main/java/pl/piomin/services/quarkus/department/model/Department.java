package pl.piomin.services.quarkus.department.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long organizationId;
    @NotBlank
    private String name;
    @Transient
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public @NotNull Long getOrganizationId() {
        return this.organizationId;
    }

    public @NotBlank String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrganizationId(@NotNull Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "Department(id=" + this.getId() + ", organizationId=" + this.getOrganizationId() + ", name=" + this.getName() + ", employees=" + this.getEmployees() + ")";
    }
}

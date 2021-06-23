package pl.piomin.services.quarkus.organization.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organization {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Transient
    private List<Department> departments = new ArrayList<>();
    @Transient
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public @NotBlank String getName() {
        return this.name;
    }

    public @NotBlank String getAddress() {
        return this.address;
    }

    public List<Department> getDepartments() {
        return this.departments;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setAddress(@NotBlank String address) {
        this.address = address;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "Organization(id=" + this.getId() + ", name=" + this.getName() + ", address=" + this.getAddress() + ", departments=" + this.getDepartments() + ", employees=" + this.getEmployees() + ")";
    }
}

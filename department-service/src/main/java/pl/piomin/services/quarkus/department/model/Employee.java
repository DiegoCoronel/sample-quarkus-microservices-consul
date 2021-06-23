package pl.piomin.services.quarkus.department.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    private Long id;
    private String name;
    private int age;
    private String position;

    public Employee() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPosition() {
        return this.position;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
        return "Employee(id=" + this.getId() + ", name=" + this.getName() + ", age=" + this.getAge() + ", position=" + this.getPosition() + ")";
    }
}

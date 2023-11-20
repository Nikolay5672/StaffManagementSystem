package Entity;

import Manager.AutoIncrementManager;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
public class Employee implements Serializable {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String department;
    private String role;
    private double salary;
    @JsonCreator
    public Employee(@JsonProperty("id") AutoIncrementManager manager, @JsonProperty("name") String name,
                    @JsonProperty("startDate") LocalDate startDate, @JsonProperty("endDate")LocalDate endDate,
                    @JsonProperty("department") String department, @JsonProperty("role") String role,
                    @JsonProperty("salary") double salary) {
        this.id = manager.getNextID();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean isActive(){
        return endDate == null;

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}

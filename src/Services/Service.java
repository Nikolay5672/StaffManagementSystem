package Services;

import Entity.Employee;

import java.util.HashMap;

public abstract class Service {
    public abstract void addEmployee(Employee employee);
    public abstract HashMap<Integer, Employee> listEmployees();
    public abstract void editEmployee(int id, Employee newEmployee);
    public abstract void fireEmployee(int id);
    public abstract HashMap<Integer, Employee> searchByDepartment(String department);
    public abstract Employee searchByID(int id);
    public abstract HashMap<Integer, Employee> searchByName(String name);
}

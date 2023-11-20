package Services;

import JSONFIlesManagement.JSONReader;
import JSONFIlesManagement.JSONWriter;
import Entity.Employee;
import java.time.LocalDate;
import java.util.HashMap;
public class StaffService extends Service {
    private JSONReader reader;
    private final JSONWriter writer;
    private final HashMap<Integer, Employee> employees; // Store employees data
    public StaffService(JSONReader reader, JSONWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.employees = reader.readAllEmployees(); // Initialize employees from JSON file
    }
    @Override
    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.put(employee.getId(), employee);
            writer.writeObjectToFile(employees); // Write updated data to the JSON file
            System.out.println("Added successfully!");
        } else {
            System.out.println("Cannot add a null employee!");
        }
    }

    @Override
    public HashMap<Integer, Employee> listEmployees() {
        return new HashMap<>(employees); // Return a new copy of the HashMap of employees
    }

    @Override
    public void editEmployee(int id, Employee updatedEmployee) {
        if (employees.containsKey(id) && updatedEmployee != null) {
            employees.put(id, updatedEmployee);
            writer.writeObjectToFile(employees); // Write updated data to the JSON file
        } else {
            if (updatedEmployee == null) {
                System.out.println("Invalid input");
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
        }
    }

    @Override
    public void fireEmployee(int id) {
        if (employees.containsKey(id)) {
            Employee employee = employees.get(id);
            LocalDate now = LocalDate.now();
            employee.setEndDate(now);
            writer.writeObjectToFile(employees); // Write updated data to the JSON file
            System.out.println("Fired successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    @Override
    public HashMap<Integer, Employee> searchByDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            HashMap<Integer, Employee> departmentEmployees = new HashMap<>();
            for (Employee employee : employees.values()) {
                if (department.equalsIgnoreCase(employee.getDepartment())) {
                    departmentEmployees.put(employee.getId(), employee);
                }
            }
            return departmentEmployees;
        } else {
            System.out.println("Department not found!");
            return new HashMap<>();
        }
    }

    @Override
    public Employee searchByID(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID. ID should be a positive number.");
            return null;
        } else {
            Employee foundEmployee = employees.get(id);
            if (foundEmployee == null) {
                System.out.println("Employee with ID " + id + " not found.");
            }
            return foundEmployee;
        }
    }

    @Override
    public HashMap<Integer, Employee> searchByName(String name) {
        if (name != null && !name.isEmpty()) {
            HashMap<Integer, Employee> nameEmployees = new HashMap<>();
            for (Employee employee : employees.values()) {
                if (name.equalsIgnoreCase(employee.getName())) {
                    nameEmployees.put(employee.getId(), employee);
                }
            }
            return nameEmployees;
        } else {
            System.out.println("No such name!");
            return new HashMap<>();
        }
    }

}





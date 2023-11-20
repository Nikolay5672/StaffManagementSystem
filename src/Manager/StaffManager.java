package Manager;

import Entity.Employee;
import Services.Service;
import java.time.LocalDate;
public class StaffManager implements Manager {
    private final Service service;
    public StaffManager(Service service) {
        this.service = service;
    }
    public void execute(String command) {
        if (command.startsWith("Add")) { //Add John Doe, IT, Developer, 50000.0
            // Extract details from the command and create a new employee object
            Employee newEmployee = parseEmployeeDetails(command);
            service.addEmployee(newEmployee);


        } else if (command.startsWith("Edit")) {  //Edit 5, Ivan, HR, Manager, 55000.0
            String[] parts = command.split(" ", 3);
            int employeeId = Integer.parseInt(parts[1]);
            String employeeDetails = parts[2]; // Represents the updated details of the employee
            // Parse the updated details to construct the updated Employee object
            Employee updatedEmployee = parseEmployeeDetails(employeeDetails);
            // Call the service to edit the employee
            service.editEmployee(employeeId, updatedEmployee);


        } else if (command.startsWith("Fire")) { // Fire 4
            int employeeId = Integer.parseInt(command.split(" ")[1]);
            // Call the service to remove the employee
            service.fireEmployee(employeeId);


        } else if (command.equals("View all")) { // View all
            System.out.println(service.listEmployees());

        } else if (command.startsWith("Search Department")) { // Search Department IT
            String department = command.split(" ", 2)[1];
            // Call the service to search employees by department
            System.out.println(service.searchByDepartment(department));

        } else if (command.startsWith("Search Id")) { // Search Id 4
            int employeeId = Integer.parseInt(command.split(" ")[2]);
            // Call the service to search by employee ID
            System.out.println(service.searchByID(employeeId));

        } else if (command.startsWith("Search Name")) {  // Search Name Ivan
            String name = command.split(" ", 2)[1];
            // Call the service to search by employee name
            System.out.println(service.searchByName(name));
        } else if (command.equals("Exit")) {
            System.out.println("Bye!");

        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    private Employee parseEmployeeDetails(String command) {
        String[] parts = command.split(" ", 2)[1].split(", ");
        String name = parts[0];
        String department = parts[1];
        String role = parts[2];
        double salary = Double.parseDouble(parts[3]);
        AutoIncrementManager manager = new AutoIncrementManager("C:\\Users\\PC18\\Desktop\\Sirma Academy\\StaffManagementSystem\\employeeIDs.txt", 100);
        LocalDate now = LocalDate.now();
        return new Employee(manager, name, now, null, department, role, salary);
    }

}

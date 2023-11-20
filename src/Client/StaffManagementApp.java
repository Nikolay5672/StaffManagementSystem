package Client;

import JSONFIlesManagement.JSONReader;
import JSONFIlesManagement.JSONWriter;
import Services.Service;
import Manager.StaffManager;
import Services.StaffService;
import Manager.Manager;
import java.util.Scanner;

public class StaffManagementApp {
    public static void main(String[] args) {
// implement fileReader/fileWriter to handle saving into csv/json
        JSONReader reader = new JSONReader("C:\\Users\\PC18\\Desktop\\Sirma Academy\\StaffManagementSystem\\src\\files\\employeeData.json");
        JSONWriter writer = new JSONWriter("C:\\Users\\PC18\\Desktop\\Sirma Academy\\StaffManagementSystem\\src\\files\\employeeData.json");
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            if (command.equals("Exit")) {
                isRunning = false;
            }

            manager.execute(command);


// Add Menu.Employee
// 1, Peter Peterson, IT, Junior Java Developer, 1400.50
// Add Menu.Employee
// 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
// Edit 1
// 1, Peter Peterson, IT, Java Developer, 2500.00
// List employees
// Search Department Marketing
// Search Id 1
// Fire 1
// Search Name Peter
// Save &amp; Exit
        }
    }

    public static void displayCommands(){
        System.out.println("View all");
        System.out.println("Add");
        System.out.println("Edit");
        System.out.println("Fire");
        System.out.println("Search Id");
        System.out.println("Search Department");
        System.out.println("Search Name");
        System.out.println("Exit");
    }


    ///git tryouts
}
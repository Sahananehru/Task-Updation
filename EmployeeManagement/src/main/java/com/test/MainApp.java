package com.test;
import java.util.List;
import java.util.Scanner;
 
public class MainApp {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();
 
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
 
            int choice = sc.nextInt();
 
            switch (choice) {
 
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
 
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
 
                    dao.addEmployee(new Employee(id, name, salary));
                    System.out.println("Employee added successfully.");
                    break;
 
                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
 
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
 
                    System.out.print("Enter New Salary: ");
                    double usalary = sc.nextDouble();
 
                    Employee updated = dao.updateEmployee(
                            new Employee(uid, uname, usalary));
 
                    if (updated != null)
                        System.out.println("Employee updated successfully.");
                    else
                        System.out.println("Employee not found.");
                    break;
 
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
 
                    dao.deleteEmployee(did);
                    System.out.println("Employee deleted (if existed).");
                    break;
 
                case 4:
                    List<Employee> employees = dao.getAllEmployees();
 
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee e : employees) {
                            System.out.println(
                                "ID: " + e.getId() +
                                ", Name: " + e.getName() +
                                ", Salary: " + e.getSalary()
                            );
                        }
                    }
                    break;
 
                case 5:
                    System.out.println("Thank you. Exiting...");
                    sc.close();
                    System.exit(0);
 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
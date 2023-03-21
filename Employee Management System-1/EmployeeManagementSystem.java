import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;

public class EmployeeManagementSystem {
    
    static final String FILE_PATH = "employees.txt";
    
    static ArrayList<Employee> employees = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        loadDataFromFile();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!exit) {
            System.out.println("Employee Management System");
            System.out.println("1. View All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;
                case 2:
                    addNewEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        saveDataToFile();
        scanner.close();
    }
    
    static void loadDataFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(parts[0]));
                employee.setName(parts[1]);
                employee.setAge(Integer.parseInt(parts[2]));
                employee.setSalary(Double.parseDouble(parts[3]));
                employees.add(employee);
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void saveDataToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getAge() + "," + employee.getSalary());
                writer.newLine();
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
    
    static void addNewEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        
        int id = employees.isEmpty() ? 1 : employees.get(employees.size() - 1).getId() + 1;
        Employee employee = new Employee(id, name, age, salary);
        employees.add(employee);
        System.out.println("Employee added successfully with ID " + id + ".");
    }
    
    static void updateEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;
        
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                found = true;
                System.out.print("Enter new employee name (blank to keep the same): ");
                String name = scanner.nextLine().trim();
                
                if (!name.isEmpty()) {
                    employee.setName(name);
                }
                
                System.out.print("Enter new employee age (0 to keep the same): ");
                int age = scanner.nextInt();
                
                if (age != 0) {
                    employee.setAge(age);
                }
                
                System.out.print("Enter new employee salary (0.0 to keep the same): ");
                double salary = scanner.nextDouble();
                
                if (salary != 0.0) {
                    employee.setSalary(salary);
                }
                
                System.out.println("Employee updated successfully.");
                break;
            }
        }
        
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void saveEmployees() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
        for (Employee employee : employees) {
            writer.write(employee.toString() + "\n");
        }
        writer.close();
    }

    public static void deleteEmployee() throws IOException {
        int id;
        System.out.println("Enter Employee id to delete the employee :");
        Scanner scan=new Scanner(System.in);
        id=scan.nextInt();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                saveEmployees();
                return;
            }
        }
    }
}


import java.io.*;
import java.util.*;
public class EmployeeDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file name:");
        String filename = scanner.nextLine();

        Management employeeManager = new Management(filename);

        while (true) {
            System.out.println("Enter operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee");
            System.out.println("3. Print All Employees");
            System.out.println("4. Exit");

            int operation = scanner.nextInt();

            if (operation == 1) {
                scanner.nextLine(); // consume newline character
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter ID:");
                int id = scanner.nextInt();

                System.out.println("Enter age:");
                int age = scanner.nextInt();

                System.out.println("Enter salary:");
                double salary = scanner.nextDouble();

                employeeManager.addEmployee(new Employee(name, id, age, salary));
            } else if (operation == 2) {
                System.out.println("Enter ID:");
                int id = scanner.nextInt();

                Employee employee = employeeManager.findEmployee(id);

                if (employee == null) {
                    System.out.println("Employee not found");
                } else {
                    System.out.println(employee);
                }
            } else if (operation == 3) {
                employeeManager.printAllEmployees();
            } else if (operation == 4) {
                break;
            } else {
                System.out.println("Invalid option ");
            }
        }
    }
}

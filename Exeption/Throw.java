import java.util.Scanner;
public class Throw {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();
                try {
                    if (age < 0) {
                        throw new IllegalArgumentException("Age cannot be negative");
                    } else {
                        System.out.println("Age: " + age);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
                scanner.close();
            }
        
        
    
}

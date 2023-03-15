import java.util.*;

public class Throws {

    public static void main(String args[]) {

        Scanner scan= new Scanner(System.in);
        System.out.println("Enter two Number :");
       int num1 = scan.nextInt();
       int num2 = scan.nextInt();
       int result;
 
       try {
          result = divide(num1, num2);
          System.out.println("Result: " + result);
       } catch (ArithmeticException e) {
          System.out.println("Error:: " + e.getMessage());
       }
    }
 
    public static int divide(int a, int b) throws ArithmeticException {
       if (b == 0) {
          throw new ArithmeticException("Cannot divide by zero");
       }
 
       return a / b;
    }
 }
 
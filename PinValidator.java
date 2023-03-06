import java.util.Scanner;

public class PinValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a four-digit pin number: ");
        int pinNumber = scanner.nextInt();
        if (isValidPinNumber(pinNumber)) {
            System.out.println("Valid pin number!");
        } else {
            System.out.println("Invalid pin number!");
        }
    }

    public static boolean isValidPinNumber(int pinNumber) {
        if (pinNumber < 100000 || pinNumber > 999999) {
            return false;
        }
        String pinString = Integer.toString(pinNumber);
        if (!pinString.matches("\\d{6}")) {
            return false;
        }
        return true;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class MenuDriven_List {

    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display elements");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice : ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the number of elements to add: ");
                    int n = scan.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter element " + (i+1) + ": ");
                        int element = scan.nextInt();
                        elements.add(element);
                    }
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    int element = scan.nextInt();
                    if (elements.remove(Integer.valueOf(element))) {
                        System.out.println("Element removed.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 3:
                    System.out.println("Elements: " + elements);
                    break;
                case 4:
                    System.out.println("Program Ended");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (option != 4);
        scan.close();
    }

}

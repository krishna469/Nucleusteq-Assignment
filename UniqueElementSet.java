import java.util.*;
public class UniqueElementSet {
    



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Taking input elements in an array
        System.out.print("Enter the size of the array: ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the "+n+" elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        // Printing the unique elements
        System.out.println("The Total elements are: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("\nThe unique elements are: ");
        for (int element : set) {
            System.out.print(element + " ");
        }
    }

}



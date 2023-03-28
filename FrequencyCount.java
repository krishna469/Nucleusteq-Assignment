import java.util.HashMap;
import java.util.Scanner;

public class FrequencyCount {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number Of Element :");
        int num = scan.nextInt();

        int[] arr = new int[num];

        System.out.println("Enter " + num + " Element :");

        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
        }

        countFrequency(arr);

    }

    private static void countFrequency(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];

            if (map.containsKey(element)) {

                int frequency = map.get(element);
                map.put(element, frequency + 1);
            } else {

                map.put(element, 1);
            }
        }
        System.out.println("Element      frequency" );
        for (int element : map.keySet()) {
            int frequency = map.get(element);
            System.out.println(element + "            " + frequency);
        }
    }
}

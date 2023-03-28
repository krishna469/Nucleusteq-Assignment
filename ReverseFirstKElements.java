import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseFirstKElements {

  public static void reverseFirstK(Queue<Integer> queue, int k) {
    if (k < 0 || k > queue.size()) {
      throw new IllegalArgumentException("Invalid value of k: " + k);
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < k; i++) {
      stack.push(queue.poll());
    }

    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }

    for (int i = 0; i < queue.size() - k; i++) {
      queue.add(queue.peek());
      queue.remove();
  }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    Scanner scan=new Scanner(System.in);

    System.out.println("Enter the number of element :");
    int num=scan.nextInt();
    
    System.out.println("Enter "+num+"elements");

    for(int i=0;i<num;i++){

       queue.offer(scan.nextInt());
    }

    System.out.println(queue);
    System.out.println("Enter the value of K :");
    int k=scan.nextInt();


    reverseFirstK(queue, k);

    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " ");
    }
  }
}

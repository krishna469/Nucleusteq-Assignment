import java.io.*;

public class CreateFile {
    public static void main(String[] args) {

        PrintWriter outputStream = null;
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Enter three lines of text:");
        String line = null;
        int count;

        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt",true));
            for (count = 1; count <= 3; count++) {
                line = keyboard.nextLine();
                outputStream.println(count + " " + line);
            }
        } catch (IOException e) {
            System.out.println("Error while creating the file \n");
        }
        outputStream.close();
        keyboard.close();
        System.out.println("... written to out.txt.");
    }
}

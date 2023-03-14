import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Read_Write {
    public static void main(String[] args) {

        java.util.Scanner scan=new java.util.Scanner(System.in);
        System.out.println("Enter file name to create file :");
        String fileName=scan.next();
        try {
            // Creating a new file
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("Enter your data here:");
            // Writing to the file
            FileWriter writer = new FileWriter(fileName);
            while (true) {
                String str=scan.nextLine();

                if(str.equals("-1"))
                    break;

                writer.write(str+"\n");

            }
            writer.close();

            // Reading from the file
            FileReader reader = new FileReader(fileName);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

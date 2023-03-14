import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile_Scanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter file content: ");
        String fileContent = scanner.nextLine();

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(fileContent);
            writer.close();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}

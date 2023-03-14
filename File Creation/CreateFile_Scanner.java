import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreateFile_Scanner {
    public static void main(String[] args) {

        Scanner scan = new java.util.Scanner(System.in);
        String name="";
        int id=0;
        float balance;
        System.out.println("Enter File Name : ");
        String fileName = scan.next();

        Scanner inFile;
        try {
            inFile = new Scanner(new File("file.txt"));
       
        while (inFile.hasNext()) {
            name = inFile.next();
            id = inFile.nextInt();
            balance = inFile.nextFloat();
            // … new Account(name, id, balance);
        }
    } catch (FileNotFoundException e) {
    
        e.printStackTrace();
    }

    }
}
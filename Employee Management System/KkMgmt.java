import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

public class KkMgmt {
    
    String file;

    KkMgmt(String file){
        this.file=file;
    }

    public void  addEmp(KKEmp employee)throws IOException{

        FileWriter fw=new FileWriter(file,true);
        PrintWriter pw=new PrintWriter(fw);

        pw.println("Employee Id : "+employee.id+"\nEmployee Name : "+employee.name+"\nAge :"+employee.age+"\nAddress :"+employee.add);

        pw.close();
        fw.close();

    }

    public void printAllEmployee()throws IOException{
        FileReader fileReader=new FileReader(file);
        BufferedReader br=new BufferedReader(fileReader);

        String line;

        while((line = br.readLine())!= null){

            String[] parts= line.split(",");
            String name = parts[0];
            int id = Integer.parseInt(parts[1]);
            int age = Integer.parseInt(parts[2]);
            String add = parts[3];
            System.out.println(new KKEmp(id, name, age, add));
        }
    }
    public KKEmp findEmploye(int id)throws IOException{
        FileReader fileReader=new FileReader(file);
        BufferedReader br=new BufferedReader(fileReader);
        String line;
        while ((line = br.readLine())!=null) {
            
            String[] parts = line.split(",");
            int employeeId = Integer.parseInt(parts[1]);
            if (employeeId == id) {
                String name = parts[0];
                int age = Integer.parseInt(parts[2]);
                String add = parts[3];
                return new KKEmp(id, name, age,add);
            }
        }

        br.close();
        fileReader.close();

        return null;
    }
        
    }







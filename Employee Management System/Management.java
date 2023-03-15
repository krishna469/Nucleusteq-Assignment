import java.io.*;


class Management {
    String filename;

    Management(String filename) {
        this.filename = filename;
    }

    void addEmployee(Employee employee) throws IOException {
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(employee.name + "," + employee.id + "," + employee.age + "," + employee.salary);

        pw.close();
        fw.close();
    }

    Employee findEmployee(int id) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int employeeId = Integer.parseInt(parts[1]);
            if (employeeId == id) {
                String name = parts[0];
                int age = Integer.parseInt(parts[2]);
                double salary = Double.parseDouble(parts[3]);
                return new Employee(name, id, age, salary);
            }
        }

        br.close();
        fr.close();

        return null;
    }

    void printAllEmployees() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0];
            int id = Integer.parseInt(parts[1]);
            int age = Integer.parseInt(parts[2]);
            double salary = Double.parseDouble(parts[3]);
            System.out.println(new Employee(name, id, age, salary));
        }

        br.close();
        fr.close();
    }
}

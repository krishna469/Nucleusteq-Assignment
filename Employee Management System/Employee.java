import java.io.*;
import java.util.Scanner;

class Employee {
    String name;
    int id;
    int age;
    double salary;

    Employee(String name, int id, int age, double salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + "\n ID: " + id + "\n Age: " + age + "\n Salary: " + salary;
    }
}
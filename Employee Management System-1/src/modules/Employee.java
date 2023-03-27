package modules;

import java.io.*;
import java.util.Scanner;

class Employee {
	Scanner sc = new Scanner(System.in);
	public String fname() {
		System.out.println("Enter file name : ");
		String filename = sc.next();
		return filename;
	}
	
    String name;
    int id;
    int age;
    double salary;

    Employee(){}

    Employee(int id,String name,  int age, double salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    
        public int getId(){
            return id;
        }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }


    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name= name;
    }

    public void setAge(int age){
        this.age= age;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nAge: " + age + "\nSalary: " + salary+"\n-----------------------------";
    }



}
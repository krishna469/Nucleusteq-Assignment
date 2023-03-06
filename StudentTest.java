import student.*;
public class StudentTest{

	public static void main(String args[]){
		
		Student s1=new Student();
		
		s1.name="krishna kumar";
		s1.rollNumber=121;
		s1.course="MCA";
		s1.mark1=45;
		s1.mark2=50;
		s1.mark3=55;
		
		
		System.out.println("total : "+ s1.calculateTotle());
		System.out.println("Average  : "+ s1.calculateAverage());
		System.out.println("Grade : "+ s1.calculateGrade());
		
		
		System.out.println(s1);
	
	}

}
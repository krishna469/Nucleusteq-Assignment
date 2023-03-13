package student;

public class StudentTest {
    public static void main(String[] args) {
		

        Student s1 = new Student();
        s1.setRollNumber(1);
        s1.setName("krishna kumar");
        s1.setCourse("MCA");
        s1.setMarks1(80);
        s1.setMarks2(60);
        s1.setMarks3(85);

        Student s2 = new Student();
        s2.setRollNumber(2);
        s2.setName("Bob");
        s2.setCourse("CS101");
        s2.setMarks1(70);
        s2.setMarks2(75);
        s2.setMarks3(80);

        Student s3 = new Student();
        s3.setRollNumber(3);
        s3.setName("Charlie");
        s3.setCourse("CS101");
        s3.setMarks1(60);
        s3.setMarks2(70);
        s3.setMarks3(65);

        Student s4 = new Student();
        s4.setRollNumber(4);
		s4.setName("Charlie");
        s4.setCourse("CS101");
        s4.setMarks1(60);
        s4.setMarks2(70);
        s4.setMarks3(65);



		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	
	}

}
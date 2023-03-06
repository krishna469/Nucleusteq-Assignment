package student;
public class Student{

	private int rollNumber;
	private String name;
	private String course;
	
	private int mark1;
	private int mark2;
	private int mark3;
	
	public int calculateTotle(){
		
		return mark1+mark2+mark3;
	
	}
	
	public int calculateAverage(){
		
		return (mark1+mark2+mark3)/3;
	}
	
	public String calculateGrade(){
		
		int grade=(mark1+mark2+mark3)/3;
		
		if(grade>80)
			return "A";
		if(grade>70&&grade<80)
			return "B";
		if(grade>50&&grade<60)
			return "C";
		if(grade>40&&grade<50)
			return "D";
		else
			return "F";
			
	}
	
	public void setName(String name){
		
		this.name=name;
	}
	
	public void setRollNumber(int rollNumber){
		
		this.rollNumber=rollNumber;
	}
	public void setCourse(String course){
		this.course=course;
	}
	
	public void setMark1(int mark1){
		
		this.mark1=mark1;
	}
	
	public void setMark2(int mark2){
		
		this.mark2=mark2;
	}
	public void setMark3(int mark3){
		
		this.mark3=mark3;
	}
	
	
	public String getName(){
		return name;
	}
	public String getCourse(){
		return course;
	}
	public int getRollNumber(){
		return rollNumber;
	}
	public int getMark1(){
		return mark1;
	}
	public int getMark2(){
		return mark2;
	}
	public int getMark3(){
		return mark3;
	}
	
	
	
	
	 public String toString() {
        return "Student{" +
                " RollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", Course =" + course +
                ", Mark1 ='" + mark1 + '\'' +
                ", Mark2='" + mark2 + '\'' +
                ", mark3='" + mark3 + '\'' +
                '}';
    }

}
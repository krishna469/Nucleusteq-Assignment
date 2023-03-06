public class Average{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	System.out.println("Enter First Number :");
	int a=scan.nextInt();
	
	System.out.println("Enter Second Number :");
	int b=scan.nextInt();
	
	System.out.println("Enter Third Number :");
	int c=scan.nextInt();
	
	
	float avg= (a+b+c)/3;
	
	System.out.println("Average of "+a+" , "+b+" , "+c+"  = "+avg);
	
	}
}
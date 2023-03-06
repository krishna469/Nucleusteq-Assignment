public class Operation_on_Number{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	System.out.println("Enter First Number :");
	int a=scan.nextInt();
	System.out.println("Enter Second Number :");
	int b=scan.nextInt();
	
	System.out.println("Sum Of "+a+" And "+b+" = "+(a+b));
	System.out.println("Subtraction Of "+a+" And "+b+" = "+(a-b));
	System.out.println("Product Of "+a+" And "+b+" = "+a*b);
	System.out.println("Division of "+a+" by "+b+" = "+a/b);
	System.out.println("Reminder of "+a+" by "+b+" = "+a%b);
	
	}
}
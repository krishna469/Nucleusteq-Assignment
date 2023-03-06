public class Interest{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	System.out.println("Enter Principle Amount :");
	double amt=scan.nextDouble();
	
	System.out.println("Enter Rate Of Interest :");
	double rate=scan.nextDouble();

	System.out.println("Enter Duration Of Time :");
	double time=scan.nextDouble();
	
	double si= (amt*rate*time)/100;
	Double ci = amt * Math.pow(1 + (rate/100), time) - amt;

	System.out.println("Simple Interest "+si);
	System.out.println("Compund Interest "+ci);
	
	}
}
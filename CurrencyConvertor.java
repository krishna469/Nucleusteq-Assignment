public class CurrencyConvertor{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	
	
	
	System.out.println("Please Enter amount in Rupee :");
	float rupee= scan.nextFloat();
	
	
	System.out.println("1 : convert in doller ");
	System.out.println("2 : convert in Euro");
	System.out.println("3 : convert in Yen");
	System.out.println("3 : convert in Rupee");
	
	System.out.println("Please Enter Respective Number to convert the amount :");
		
	int option=scan.nextInt();
		
	switch(option){
			
			case 1:
				System.out.println("Amount in Doller : "+ rupee*0.80);
			break;
			case 2:
				System.out.println("Amount in Euro : "+ rupee*0.87);
			break;
			case 3:
				System.out.println("Amount in Yen : "+ rupee*1.66);
			break;
			case 4:
				System.out.println("Amount in Rupee : "+ rupee);
			break;
			default:
				System.out.println("Invilid Input !! ");

				
	}

	
	
   }
}
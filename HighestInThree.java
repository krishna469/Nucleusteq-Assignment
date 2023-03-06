public class HighestInThree{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);

	System.out.println("Enter First Number :");
	int one= scan.nextInt();
	
	System.out.println("Enter Second Number :");
	int two= scan.nextInt();
	
	System.out.println("Enter Third Number :");
	int three= scan.nextInt();

	int max=0;
	
	if(one>two){
		
		if(one>three){
			
			System.out.println("the Highest Number is : "+ one);
		}else{
			System.out.println("the Highest Number is : "+ three);
		}
	}else{
		
		if(two>three){
			
			System.out.println("the Highest Number is : "+ two);
		}else{
		
			System.out.println("the Highest Number is : "+ three);

		}
	}
 }
}
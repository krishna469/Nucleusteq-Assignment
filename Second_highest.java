public class Second_highest{

	public static void main(String args[]){
	
	java.util.Scanner scan=new java.util.Scanner(System.in);
	
	
	int max=Integer.MIN_VALUE;
	int secondMax=Integer.MIN_VALUE;
	
	System.out.println("Enter Number Of Element :");
	int n=scan.nextInt();
	
	System.out.println("Enter "+n+" Number");
	
	int arr[]=new int[n];
	
	for(int i=0;i<n;i++){
		arr[i]=scan.nextInt();
	}
	
	
	for(int i=0;i<n;i++){
	
			if(arr[i]>max){
				
				secondMax=max;
				max=arr[i];
			}else if(arr[i]>secondMax && arr[i]!=max){
				
				secondMax=arr[i];
			}	
	}
	
	System.out.println("Second Highest Number  "+secondMax);
	
   }
}
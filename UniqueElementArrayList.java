import java.util.*;


public class UniqueElementArrayList {
	
	public static void main(String[] args) {

		List<Integer> list=new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of element you want :");
		int n=scan.nextInt();
		System.out.println("Enter "+n +" elements :");
		for(int i=0;i<n;i++){
			list.add(scan.nextInt());
		}


		List<Integer> uniqueList=new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			
			int num=list.get(i);
			if(!uniqueList.contains(num)) {
				uniqueList.add(num);
			}
		}
		
		System.out.println(uniqueList);
		
		
	}

}

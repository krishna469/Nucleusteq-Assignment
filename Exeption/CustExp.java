
class CustomException extends Exception {
    

}


public class CustExp {
	public static void main(String args[])
	{
		try {
			
			throw new CustomException();
		}
		catch (CustomException e) {
			System.out.println("Custom Exception Occured !!");
			System.out.println(e.getMessage());
		}
	
}
}

public class CheckStringForDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "123Geeks";
		String s2 = "123456";
		
		//if(s2.matches("[0-9]+"))  or
		if(s1.matches("\\d+"))
			System.out.println("String contains only digits");
		else
			System.out.println("String does not contain only digits");
			

	}

}

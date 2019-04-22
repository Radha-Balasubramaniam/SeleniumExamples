
public class ConvertStringtoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345";
		int convertedInt;
		
		//convert string to int
		convertedInt = Integer.parseInt(s);
		System.out.println("String converted to int is "+convertedInt);
		
		//convert int to string
		String convertedString = null;
		convertedString = String.valueOf(convertedInt);
		System.out.println("int converted to String is "+convertedString);
		//or
		System.out.println(Integer.toString(convertedInt));
	}

}

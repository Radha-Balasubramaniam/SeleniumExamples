//Java program to count the number of occurrences of a given character in String without using loop
public class CountCharacterOccurrenceInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "GeeksforGeeks";
		
		//Without using loops		
		int count = str.length()-str.replaceAll("e", "").length();
		System.out.println("No of occurrences of e is "+count);
		
		//Using loops
		int charcount=0;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)=='G'){
				charcount++;
			}
		}
		
		System.out.println("No of occurrences of G is "+count);
	}

}


public class ReverseString {
	//using recursion
	public static void reverseString(String str) {
		
		if(str.length()>0){
		System.out.print(str.charAt(str.length()-1));
		str = str.substring(0,str.length()-1);
		reverseString(str);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Selenium tutorial";
	/*	String rev="";
		for (int i = s.length()-1; i >=0; i--) {
			rev+=s.charAt(i);
		}
		System.out.println("Reversed String is "+ rev);*/
		
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		System.out.println("Reversed String is "+sb.toString());
		
		
		//Using recursion
		reverseString("Selenium tutorial");

	}

}

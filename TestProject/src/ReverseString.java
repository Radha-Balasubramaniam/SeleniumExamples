
public class ReverseString {

	public static void reverseString(String s) {
	/*	String s2="";
		for (int i=s.length()-1;i>=0;i--)
		{
			s2 += s.charAt(i);
		}
		System.out.println(s2);	
		*/
		
		/*StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--)
		{
			sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());*/
		
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	
	public static void main(String[] args) {
		
		reverseString("A man, a plan, a canal: Panama");
	}	
	
}

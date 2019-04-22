package javatpoint;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Brag";
		String s2 = "Grab";
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch1, ch2))
			System.out.println("Strings are anagram");
		else
			System.out.println("Strings are not anagram");
	}	

}

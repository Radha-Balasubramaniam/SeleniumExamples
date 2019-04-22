package stringexamples;

public class StringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "GeeksforGeeks";
		// Returns the number of characters in the String. 
		System.out.println("String length is "+s.length());
		// Returns the character at ith index. 
		System.out.println("Character at 3rd position = "+s.charAt(3));
		// Return the substring from the ith  index character 
        // to end of string 
		System.out.println("Substring "+s.substring(3));
		// Returns the substring from i to j-1 index. 
		System.out.println("Substring = "+s.substring(3,5));
		// Concatenates string2 to the end of string1. 
		String s1 = "Geeks";
		String s2 = "forGeeks";
		System.out.println("Concatenated String = "+ s1.concat(s2));
		// Returns the index within the string 
        // of the first occurrence of the specified string. 
		System.out.println("index of e = "+ s.indexOf("eks"));
		// Returns the index within the string of the 
        // first occurrence of the specified string, 
        // starting at the specified index.
		System.out.println("index of e from 4th= "+s.indexOf('e',5));
		// Checking equality of Strings
		Boolean out = s1.equals(s2);
		System.out.println("S1 and S2 comparision = "+out);
		out = s.equals(s1+s2);
		System.out.println("S and S1+S2 comparision = "+out);
		out = "Geeks".equalsIgnoreCase("gEeks "); 
        System.out.println("Checking Equality" + out); 
  
        int out1 = s1.compareTo(s2); 
        System.out.println("If s1 = s2" + out); 
  
        // Converting cases 
        String word1 = "GeeKyMe"; 
        System.out.println("Changing to lower Case " + 
                            word1.toLowerCase()); 
  
        // Converting cases 
        String word2 = "GeekyME"; 
        System.out.println("Changing to UPPER Case " +  
                            word1.toUpperCase()); 
  
        // Trimming the word 
        String word4 = " Learn Share Learn "; 
        System.out.println("Trim the word " + word4.trim()); 
  
        // Replacing characters 
        String str1 = "feeksforfeeks"; 
        System.out.println("Original String " + str1); 
        String str2 = "feeksforfeeks".replace('f' ,'g') ; 
        System.out.println("Replaced f with g -> " + str2); 
	}

}

import java.util.Arrays;

//Java program to check two strings are anagram or not
public class AnagramStrings {
	
	// Using arrays sort
	public static boolean isAnagram(String str1,String str2){
		
		// Get lenghts of both strings 
        int n1 = str1.length(); 
        int n2 = str2.length(); 
        char str1char[] = str1.toCharArray();
        char str2char[] = str2.toCharArray();
  
        // If length of both strings is not same, 
        // then they cannot be anagram 
        if (n1 != n2) 
            return false; 
  
        // Sort both strings 
        Arrays.sort(str1char); 
        Arrays.sort(str2char); 
  
        // Compare sorted strings 
        for (int i = 0; i < n1; i++) {
            if (str1char[i] != str2char[i]) 
                return false; 
        }
        return true; 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "listen";
		String str2 = "silent";
		int found=0;
		// Using for loop
		if(str1.length() != str2.length()){
			System.out.println("Strings are not anagram");
		}
		
		else {		
		for(int i=0;i<str1.length();i++){
			found = 0;
			for(int j=0;j<str1.length();j++){
				if(str1.charAt(i) == str2.charAt(j)) {
					found =1;
				    break;
				}
		}}
		if(found==1)
			System.out.println("Strings are anagram");
		else
			System.out.println("Strings are not anagram");
		}	
		isAnagram(str1, str2);
	}

}

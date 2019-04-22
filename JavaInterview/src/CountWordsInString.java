//Java program to count no of words in a String
public class CountWordsInString {
	
	public static void countWords(String str){
		String split[] = str.split("\\s+");
		System.out.println("No of words in a string are "+ split.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Program to  count words";
		countWords(str);
		int count = 1;
		
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)!=' ' && str.charAt(i+1)==' '){
				count++;				
			}
		}
		
		System.out.println("No of words in a string are "+ count);

	}

}

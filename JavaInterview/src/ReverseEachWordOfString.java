
public class ReverseEachWordOfString {

	public static void main(String[] args) {
		String str = "This is reverse string program";
		String[] words = str.split(" ");		
		String reverseString="";
		for(int i=0; i<words.length;i++){
			String word = words[i];
			String reverseword="";
			for(int j=word.length()-1;j>=0;j--){
				reverseword+=word.charAt(j);
			}
			reverseString=reverseString+reverseword+" ";
		}
		System.out.println("Reversed String is "+reverseString);

	}

}

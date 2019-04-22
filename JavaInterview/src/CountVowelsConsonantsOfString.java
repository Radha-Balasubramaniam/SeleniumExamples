
public class CountVowelsConsonantsOfString {

	public static void main(String[] args) {
		int vCounter =0;
		int cCounter=0;
		String str = "VowelConsonantString";
		for(int i=0;i<str.length()-1;i++){
			char ch = str.charAt(i);
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
				++vCounter;
				
			}
			else 
				++cCounter;
		}
		System.out.println("Vowels count is "+vCounter);
		System.out.println("Consonants count is "+cCounter);

	}

}

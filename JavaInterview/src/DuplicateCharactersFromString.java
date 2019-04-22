import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Java program to print duplicate characters from String with number of occurrences
public class DuplicateCharactersFromString {
	
	public static void displayduplicates(String str) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] ch = str.toCharArray();
		for(char c:ch){
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		Set<Entry<Character,Integer>> entryset = map.entrySet();
		for(Entry<Character,Integer> entry : entryset){
			if(entry.getValue()>1){
				System.out.printf("%s : %d %n",entry.getKey(),entry.getValue());
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//using hashmap
		displayduplicates("w3schools");
		
		
		//Using for loops
		String s = "w3schools";
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)) {
					System.out.println(s.charAt(i));
					break;
				}		
			
			}
		}

	}

}

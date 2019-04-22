import java.util.HashMap;
import java.util.Map;;

//Java Program to find first non repeated character in a String
public class FirstNonRepeatedCharinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GeeksforGeeks";
		char[] ch = str.toCharArray();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<=ch.length-1;i++){
			if(!map.containsKey(ch[i])){
				map.put(ch[i], 1);
			}
			else
				map.put(ch[i], map.get(ch[i])+1);
		}
		
		System.out.println(map);
		
		for(int i=0;i<=ch.length-1;i++){
			char c = ch[i];
			if(map.get(c)==1){
				System.out.println("First occurence of non repeated character is "+c);
				break;
			}
			
		}
				
	}

}

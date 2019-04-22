package javatpoint;

public class StringPermutations {

	public static String swap(String str,int start,int end){
		
		char[] ch = str.toCharArray();
		
		char temp;
		temp = ch[start];
		ch[start]=ch[end];
		ch[end]=temp;
		
		return String.valueOf(ch);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "ABC";
		
		int len = s.length();
		int start = 0;
		generatePermutation(s,start,len);

	}

	private static void generatePermutation(String s, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start==end-1){
			System.out.println(s);
		}
		
		for(int i=start;i<end;i++){			
			String str;			
			str = swap(s,start,i);
			generatePermutation(str,start+1,end);
			str = swap(str,start,i);
			
		}
		
		
	}

}

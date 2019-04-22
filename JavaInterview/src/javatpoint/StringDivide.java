package javatpoint;

public class StringDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaabbbbbeeeee";
		int len = s.length();
		int n = len/5;
		String s1[] = new String[5];
		int index=0;
		
		for(int i=0;i<len;i=i+n){
			String temp = s.substring(i, i+n);
			s1[index] = temp;
			index++;			
		}
		
		for(int i=0;i<s1.length;i++){
			System.out.println(s1[i]);
		}

	}

}

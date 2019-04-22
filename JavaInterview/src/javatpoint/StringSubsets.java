package javatpoint;

public class StringSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "ABCD";
		int len = s.length();
		String subset[] = new String[len*(len+1)/2];
		int temp=0;
		
		for(int i=0;i<len;i++){
			for(int j=i;j<len;j++){
				subset[temp] = s.substring(i, j+1);
				temp++;
			}
		}
		
		for(int i=0;i<subset.length;i++){
			System.out.println(subset[i]);
		}

	}

}

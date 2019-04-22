package stringexamples;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer str = new StringTokenizer("Geeks for Geeks"," ",false);
		
		while(str.hasMoreTokens())
			System.out.println(str.nextToken());

	}

}

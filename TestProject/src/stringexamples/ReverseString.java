package stringexamples;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first String:");
		int t = sc.nextInt();
		while(t>0){
			
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = s1.concat(s2);
		String s4 = "";
		for(int i=s3.length()-1;i>=0;i--){
			s4+=s3.charAt(i);
		}
		System.out.println(s4);
		t--;
		}
	}

}

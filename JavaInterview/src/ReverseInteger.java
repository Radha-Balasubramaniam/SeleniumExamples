
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int num=12345678;
		int rev=0;
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		
		System.out.println("Reversed number is "+ rev);*/
		
		int num1 = 54321;
		String s = new StringBuffer(String.valueOf(num1)).reverse().toString();
		System.out.println("Reversed number is "+Integer.parseInt(s));
	}

}

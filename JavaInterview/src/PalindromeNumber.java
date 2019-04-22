
public class PalindromeNumber {
	
	public static boolean isPalindromeNumber(int num) {
		int reverse = 0;
		int original = num;
		while(num>0){
			reverse = reverse*10+num%10;
			num = num/10;
		}
		if(reverse == original)
			return true;
		return false;		
	}

	public static void main(String[] args) {
		System.out.println("789876 is palindrome:"+isPalindromeNumber(789876));
		System.out.println("78987 is palindrome:"+isPalindromeNumber(78987));
		System.out.println("1 is palindrome:"+isPalindromeNumber(1));
		System.out.println("111 is palindrome:"+isPalindromeNumber(111));
	}

}

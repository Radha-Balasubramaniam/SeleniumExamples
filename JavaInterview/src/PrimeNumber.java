public class PrimeNumber {
	
	public static boolean isPrimeNumber(int num) {		
		if(num<=1)
		return false;		
		for(int i=2;i<num;i++){
			if(num%i==0)
				return false;
		}
		return true;		
	}
	
	public static void getPrimeNumbers(int n) {
		for(int i=2;i<=n;i++){
			if(isPrimeNumber(i)){
				System.out.print(i+" ");
			}
		}
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("2 is prime number:" + isPrimeNumber(2));
		getPrimeNumbers(20);
		

	}

}

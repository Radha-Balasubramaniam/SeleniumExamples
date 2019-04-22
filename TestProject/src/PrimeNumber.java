public class PrimeNumber {
	private static void primeNumber(int n) {
		int n1 = n/2,flag = 0;
		for(int i=2;i<n1;i++){
			if(n%i==0){
				System.out.println("Given Number is not a Prime");
				flag=1;
				break;
			}
		
		}
		
	if(flag==0)
		System.out.println("Given Number is a Prime");
	}
		
		public static void main(String[] args) {
			primeNumber(15);
		}
}

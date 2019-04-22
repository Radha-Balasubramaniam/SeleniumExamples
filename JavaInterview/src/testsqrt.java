
public class testsqrt {

	public static void main(String[] args) {
		
		System.out.print(2+" "+3);
		for(int i=4;i<100;i++){
			boolean result = isPrimeNumber(i);
			if(result==true)
				System.out.print(" "+i);
		}
	}

	private static boolean isPrimeNumber(int i) {
		if(i==2 || i==3)
			return true;
		if(i%2==0)
			return false;
		int sqrtnum = (int)Math.sqrt(i);
		for(int j=3;j<=sqrtnum;j++){
			if(i%j==0)
				return false;
		}
		return true;
		
	}

}

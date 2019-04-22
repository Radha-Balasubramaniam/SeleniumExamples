import java.util.Arrays;

//with recursion
/*public class FibonacciSeries {
	static int n1=0,n2=1,n3=0;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 10;
		System.out.print(0+" "+1);
		fibonacci(count-2);
		
	}

	private static void fibonacci(int count) {
		// TODO Auto-generated method stub
			
		if(count>0){
			n3 = n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
			fibonacci(count-1);
		}
		
	}	

}*/

//without recursion

/*class FibonacciSeries{  
	
	private static void fibonacci(int count) {
	int n1=0,n2=1,n3=0;
	if(count>0) {
	 System.out.print(n1+" "+n2);
	 for(int i=2;i<count;i++){
		 n3 = n1+n2;
		 n1=n2;
		 n2=n3;
		 System.out.print(" "+n3);
	 }
	 
    }
	}
	
	public static void main(String[] args) {
		fibonacci(1);
	}
}*/

//Dynamic programming
/*class FibonacciSeries{  
	
	private static void fibonacci(int n) {
	int[] x = new int[n];
	x[0] = 0;
	x[1] = 1;
	for(int count=2;count<n;count++){
	x[count] = x[count-1]+x[count-2];
	}
	System.out.println(Arrays.toString(x));
	
	}
	
	public static void main(String[] args) {
		fibonacci(10);
	}
}*/

class FibonacciSeries {
	
	public static void main(String[] args) {
		for(int i=1; i<=8; i++){ System.out.print(f(i)+" "); }
	}
	
	public static int f(int n){
		int result;
		if(n==1 || n==2){
			 return 1;
		}
		else
			return f(n-1)+f(n-2);
		
	}
}
	

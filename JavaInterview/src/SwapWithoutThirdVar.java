
public class SwapWithoutThirdVar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=5,y=10;
		
		//Solution1 using + , -
		x=x+y; //15
		y=x-y; //5
		x=x-y; //10
		System.out.println("X = "+x+" Y = "+y);
		
		//Solution2 using *
		x=5;y=10;
		x = x * y; // 50
		y = x / y; // 5
		x = x / y; // 10
		
		System.out.println("X = "+x+" Y = "+y);
		
		//Solution3 using XOR
		x=5;y=10;
		x = x ^ y; //15 --> 1111
		y = x ^ y; //10 --> 1010
		x = x ^ y; //5  --> 0101

	}

}

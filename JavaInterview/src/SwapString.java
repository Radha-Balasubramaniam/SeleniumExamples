
public class SwapString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello";
		String b = "world";
		
		System.out.println("Before Swapping "+"a="+a+" b="+b);
		a = a+b; //helloworld
		b = a.substring(0,a.length()-b.length());
		a = a.substring(b.length());
		System.out.println("After Swapping "+"a="+a+" b="+b);
		

	}

}


public class Test {
	
	static int i = 10;

	public void method1() {
		i++;
		System.out.println(Math.random());
		
	}
	public void method2() {
		i++;
		
	}
	public void method3() {
		System.out.println(i);
		
	}
	public static void main(String[] args) {
		
		Test t = new Test();
		t.method1();
		t.method2();
		t.method3();
		
	}
}

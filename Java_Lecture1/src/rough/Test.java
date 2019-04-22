package rough;

import pckg1.ClassA;
import pckg1.ClassB;

public class Test {
	
	public int publicVariable = 10;
	private int privateVariable = 20;
	protected int protectedVariable = 30;
	int defaultVariable = 40;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassA obj = new ClassA();
		obj.add();
		
		ClassB obj2 = new ClassB();
		obj2.show();
		
		Test t = new Test();
		System.out.println(t.defaultVariable);
		System.out.println(t.privateVariable);
		System.out.println(t.protectedVariable);
		System.out.println(t.publicVariable);

	}

}

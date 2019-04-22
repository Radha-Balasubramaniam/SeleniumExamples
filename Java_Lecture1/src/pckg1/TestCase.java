package pckg1;

import rough.Test;

public class TestCase extends Test{
	
	public static void main(String[] args) {

	ClassA obj = new ClassA();
	obj.add();
	
	ClassB obj2 = new ClassB();
	obj2.show();
	
	//Test t = new Test();
	TestCase t = new TestCase();
	//System.out.println(t.defaultVariable);
	//System.out.println(t.privateVariable);
	System.out.println(t.protectedVariable);
	System.out.println(t.publicVariable);

	
	}
}

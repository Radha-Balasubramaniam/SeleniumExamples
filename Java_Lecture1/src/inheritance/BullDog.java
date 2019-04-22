package inheritance;

public class BullDog extends Dog {
	
	int x = 10;
	
	public static void main(String[] args) {
	
		Dog obj = new BullDog();
		obj.sound();
		//obj.test();
		System.out.println(obj.x);
	}
	public static void run(){
		System.out.println("Run inside Dog");
	}
	
	public void sound() {
		System.out.println("Inside Bull Dog");
	}
	public void test(){
		System.out.println("Inside test");
	}
}
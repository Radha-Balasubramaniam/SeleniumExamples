package inheritance;

public class Dog extends Animal{
	
	int x=20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal obj = new Dog();
		obj.sound();
		obj.animalmethod();
		obj.sound();
		
	}
	
	public void sound() {
		System.out.println("Inside Dog");
	}
	
	public static void run(){
		System.out.println("Run inside Dog");
	}

}

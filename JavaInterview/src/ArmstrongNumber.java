
public class ArmstrongNumber {
	
	
	public static boolean isArmstrongNum(int num) {
		int x;
		int cube=0;
		int original = num;
		while(num>0){
			x = num%10;
			cube = cube + (x*x*x);
			num = num/10;							
		}
		
		if(cube == original)
			return true;
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println("143 is Armstrong "+ isArmstrongNum(153));

     }
	
}

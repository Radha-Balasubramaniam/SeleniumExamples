package javatpoint;

public class DeficientNumber {
	
	public static int DeficientNumber(int num){
		int result=0;
		for(int i=1;i<=num;i++){
			int rem=num%10;
			if(rem==0){
				result=result+num;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int finalresult,input=21;
		finalresult = DeficientNumber(input);
		if(finalresult<input){
			System.out.println(input+"  is a Deficient Number");
		}

	}

}

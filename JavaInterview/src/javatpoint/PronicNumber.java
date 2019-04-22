package javatpoint;

public class PronicNumber {
	
	
	public static boolean PronicNumber(int num){
		int result;
		boolean flag=false;
		for(int i=1;i<=num;i++){
			result = i*(i+1);
			if(result==num){
				flag = true;
				break;
			}			
		}
		return flag;
	}

	public static void main(String[] args) {
		boolean pronicresult=false;
		for(int i=1;i<=100;i++){
		pronicresult = PronicNumber(i);
		if(pronicresult==true)
			System.out.println(i);
		}

	}

}

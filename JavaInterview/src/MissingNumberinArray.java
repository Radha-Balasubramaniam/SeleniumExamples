
public class MissingNumberinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,7,8,9,10};
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		System.out.println("sum of elements in array is "+sum);
		
		int sum1=0;
		for(int j=1;j<=10;j++){
			sum1+=j;
		}
		System.out.println("Expected sum is "+sum1);
		
		System.out.println("Missing number is "+(sum1-sum));
	}

}

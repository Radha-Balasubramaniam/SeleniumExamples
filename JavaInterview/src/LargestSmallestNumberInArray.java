import java.util.Arrays;

public class LargestSmallestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-10,30,20,-70,16,8};
		int largest = a[0];
		int smallest = a[0];
		
		for(int i=1;i<a.length;i++){
			if(a[i]>largest) {
				largest = a[i];
			}
			else if(a[i]<smallest){
				smallest = a[i];
			}
		}
		
		System.out.println("Given array is "+Arrays.toString(a));
		System.out.println("Largest Number is "+largest);
		System.out.println("Smallest Number is "+smallest);

	}

}

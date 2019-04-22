package javatpoint;

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] arr = new int [] {1, 2, 3, 4, 5};   
		 int n=3,first,j;
		 
		 for(int i=0;i<n;i++){
			 first = arr[0];
			 for(j=0;j<arr.length-1;j++){
				 arr[j]=arr[j+1];
			 }
			 arr[j]=first;
		 }
		 
		 for(int k=0;k<arr.length;k++){
			 System.out.println(arr[k]);
		 }

	}

}

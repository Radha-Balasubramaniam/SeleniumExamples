import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovingZeros {

public static void moveZeroes(int[] nums) {
	int[] temp = null;
	Arrays.sort(nums);
	for(int i=0;i<nums.length-1;i++){
		if(nums[i]==0){
			temp[i]=i;
		}
	}
	
        
    }
	public static void main(String[] args) {
		
		int[] nums2 = {2,2,2,1};		
		moveZeroes(nums2);
		
	}	
	
}

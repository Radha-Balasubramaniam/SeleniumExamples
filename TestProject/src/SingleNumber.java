import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {

public static int singleNumber(int[] nums) {
	Arrays.sort(nums);
	for(int i=0;i<nums.length-1;i+=2){
		if(nums[i] != nums[i+1]) {
			return nums[i];
		}
	}
	
	return nums[nums.length-1];
        
    }
	public static void main(String[] args) {
		
		int[] nums2 = {2,2,2,1};		
		int result = singleNumber(nums2);
		System.out.println(result);
	}	
	
}

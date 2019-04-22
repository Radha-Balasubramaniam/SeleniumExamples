package javatpoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayElementFrequency {
	
	public static void main(String[] args) {
        int[] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};  
     /*   int[] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int count=1;
            for(int j=i+1;j<arr.length;j++){
               if(arr[i]==arr[j]) {
                ++count;
               arr2[j]=-1;
               }
            }
            if(arr2[i]!=-1){
                arr2[i]=count;
            }
        }
        
        
        for(int i=0;i<arr.length;i++){
            if(arr2[i]!=-1){
                System.out.println(arr[i]+" "+arr2[i]);
            }
        }*/
        
        
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
        boolean flag = hmap.containsKey(arr[i]);
        if(flag == true)
        	hmap.put(arr[i], hmap.get(arr[i])+1);
        else
        	hmap.put(arr[i], 1);
        }
        
      //Set entry = hmap.entrySet();
        hmap.entrySet().forEach(entry->{ System.out.println(entry.getKey()+" "+entry.getValue());
        
        });
        
        for(Map.Entry entry : hmap.entrySet()){
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        
        }
        }
        

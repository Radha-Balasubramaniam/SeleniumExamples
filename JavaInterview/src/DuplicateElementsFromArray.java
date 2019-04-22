import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateElementsFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[]={"Java","JavaScript","Java","Ruby","C","Python","C","Java"};
		//1. compare each element: O(n*n) --- worst solution
		for(int i=0;i<names.length;i++){
			for(int j=i+1;j<names.length;j++){
				if(names[i].equals(names[j])){
					System.out.println("Duplicate element is "+names[i]);
				}
			}
		}
		
		System.out.println("********************");
		
		//2. Using HashSet : JavaCollection: it stores unique values: O(n)		
		Set<String> store = new HashSet<String>();
		for(String name : names) {
			if(store.add(name) == false){
				System.out.println("Duplicate element is "+name);
			}
		}
		
		System.out.println("********************");
		
		// Using HashMap
		Map<String,Integer> mapstore = new HashMap<String,Integer>();
		
		for(String name : names){
			Integer count = mapstore.get(name);
			if(count == null) {
				mapstore.put(name, 1);
			}
			else {
				mapstore.put(name, ++count);
			}
		}
		
		
		//get the values from the HashMap
		Set<Entry<String,Integer>> entrySet = mapstore.entrySet();
		for(Entry<String,Integer> entry : entrySet){
			if(entry.getValue()>1)
				System.out.println("Duplicate element is "+ entry.getKey());
		}
		
	}

}

package ListConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class HashMapConcept {

	public static void main(String[] args) {
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "Selenium");
		hm.put(2, "QTP");
		hm.put(3, "Cucumber");
		
		System.out.println(hm.get(1));
		System.out.println(hm.get(4));
		
		for(Entry entry : hm.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		
		List<String> li = Collections.synchronizedList(new ArrayList<String>());
		
		

	}

}

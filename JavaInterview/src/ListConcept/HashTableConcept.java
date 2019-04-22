package ListConcept;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashTableConcept {

	public static void main(String[] args) {
		
		Hashtable ht = new Hashtable();
		ht.put("A", "Selenium");
		ht.put("B", "QTP");
		ht.put("C", "Test");
		
		if(ht.containsValue("Test"))
			System.out.println("Value is found");
		
		Enumeration e = ht.elements();
		while(e.hasMoreElements())
			System.out.println(e.nextElement());
		
		//get values using entryset
		
		Set s = ht.entrySet();
		System.out.println(s);
		
		Hashtable ht1 = new Hashtable();
		ht1.put("A", "Selenium");
		ht1.put("B", "QTP");
		ht1.put("C", "Test");
		
		//check equality of hashtables
		if(ht1.equals(ht))
			System.out.println("Both are equal");
		
		//get value from key
		System.out.println(ht.get("A"));
		
		//get hashcode of hashtable object
		System.out.println("The hashcode value  of ht is "+ ht.hashCode());
		
		
		HashTableConcept htc = new HashTableConcept();
		
	}

}

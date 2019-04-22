package list;

import java.io.Serializable;
import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList l = new ArrayList();
		
		l.add("Radha");
		l.add("Radha");
		l.add("44");
		l.add(null);
		System.out.println(l);
		
		l.remove(2);
		l.add(45);
		l.add(46);
		System.out.println(l);
		
		l.add(5,47);
		System.out.println(l);
		
		
		
		System.out.println(l instanceof Serializable);
		System.out.println(l instanceof Cloneable);
		System.out.println(l instanceof RandomAccess);
		
		LinkedList l1 = new LinkedList<>();
		
		
		l1.add(12);
		l1.addAll(l);
		
		
		
		
		
		

	}

}

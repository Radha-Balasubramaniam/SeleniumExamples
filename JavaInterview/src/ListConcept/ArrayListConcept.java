package ListConcept;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[3];
		a[0]=10;
		a[1]=20;
		a[2]=30;
		
		ArrayList ar = new ArrayList<>();
		ar.add(10);
		ar.add(20);
		ar.add(30);
		System.out.println(ar.size());
		
		ar.add(40);
		ar.add(50);
		ar.add(50);		
		System.out.println(ar.size());
		
		Iterator itr = ar.iterator();
		while(itr.hasNext()){
			int i = (Integer) itr.next();
			System.out.print(i+" ");
		}
		System.out.println("");
		ListIterator litr = ar.listIterator();
		while(litr.hasNext()){
			System.out.print(litr.next()+" ");
		}
		System.out.println("");
		while(litr.hasPrevious()){
			System.out.print(litr.previous()+" ");
		}
	}

}

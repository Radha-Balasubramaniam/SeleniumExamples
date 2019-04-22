package ListConcept;

import java.util.LinkedList;

public class LinkedListConcept {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("test");
		ll.add("qtp");
		ll.add("selenium");
		ll.add("rpa");
		ll.add("rft");
		ll.add("rft");
		
		System.out.println("Contents of Linkedlist are "+ll);
		
		//addFirst
		ll.addFirst("testng");
		//addLast
		ll.addLast("automation");
		System.out.println("Contents of Linkedlist are "+ll);
		
		//getElement
		System.out.println(ll.get(0));
		
		//insertion
		ll.set(0, "tomcat");
		System.out.println(ll.get(0));
		
		//remove
		ll.removeFirst();
		ll.removeLast();
		System.out.println("Contents of Linkedlist are "+ll);
		ll.remove(2);
		System.out.println("Contents of Linkedlist are "+ll);
		
		
		
	}

}

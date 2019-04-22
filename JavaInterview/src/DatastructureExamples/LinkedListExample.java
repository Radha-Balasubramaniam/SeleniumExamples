package DatastructureExamples;

import java.util.LinkedList;

public class LinkedListExample {
	
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void display(){
		Node n = head;
		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void reverse(Node current) {  
        //Checks if list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
          //  return;  
        }  
        else {  
            //Checks if the next node is null, if yes then prints it.  
            if(current.next == null) {  
                System.out.print(current.data + " ");  
                return;  
            }  
            //Recursively calls the reverse function  
            reverse(current.next);  
            
        }  
        System.out.print(current.data + " ");  
    }  

	

	public static void main(String[] args) {
		LinkedListExample list = new LinkedListExample();  
		  
		list.head = new Node(100);  
		Node second = new Node(200);  
		Node third = new Node(300);  
		  
		list.head.next = second; // Link first node with the second node  
		second.next = third; // Link first node with the second node  
		  
		list.display();  
		
		list.reverse(list.head);

	}

}

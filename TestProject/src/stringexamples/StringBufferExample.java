package stringexamples;

public class StringBufferExample {

	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Geeksfor"); 
		System.out.println(s.length());
		System.out.println(s.capacity());
        s.append("Geeks"); 
        System.out.println(s); //returns GeeksforGeeks 
        s.append(1); 
        System.out.println(s); //returns GeeksforGeeks1 
        char n[] = { 'a','b','c'};
        s.insert(14,n );
        System.out.println(s);
        s.reverse();
        System.out.println(s);

	}

}

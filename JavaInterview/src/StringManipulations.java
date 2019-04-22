
public class StringManipulations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "The rains have started here in secunderabdad";
		String str1 = "The rains have started here in Secunderabdad";
		String str2 = " The rains have started here in Secunderabdad ";
		System.out.println(str.length());
		System.out.println(str.charAt(8));
		System.out.println(str.indexOf('s')); //first occurrence of s
		System.out.println(str.indexOf('s', str.indexOf('s')+1)); //second occurrence of s
		System.out.println(str.indexOf('s',str.indexOf('s', str.indexOf('s')+1)+1)); //third occurence of s
		System.out.println(str.indexOf("here"));
		System.out.println(str.indexOf("hello"));
		
		//String comparision
		System.out.println(str.equalsIgnoreCase(str1));
		System.out.println(str.equals(str1));
		
		//SubString 
		System.out.println(str.substring(0, 8));
		System.out.println(str.substring(10));
		
		//trim
		System.out.println(str2.trim());
		
		//replace
		System.out.println(str2.replace(" ", ""));
		
		//Split
		String test = "Hello_World_Test_Selenium";
		String testval[] = test.split("_");
		for(int i=0;i<testval.length;i++){
			System.out.println(testval[i]);
		}
		
		
	
	
	}

}

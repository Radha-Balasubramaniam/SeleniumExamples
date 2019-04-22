package javatpoint;

/*82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
82 is a happy number number*/

public class HappyNumberWithRange{
    
    public static int happyNumber(int num){
         int sum=0,rem;
    while(num>0){
      rem = num%10;
      sum = sum+(rem*rem);
      num = num/10;
    }
    return sum;
   }
 
 public static void main(String []args){
    System.out.println("Hello World");
    
   for(int num=1;num<=100;num++) { 
	 int result=num;  
    while(result!=1 && result!=4){
        result = happyNumber(result);
    }
    
  //Happy number always ends with 1  
    if(result == 1)  
        System.out.println(num + " ");  

   }
 }   
    
 
}

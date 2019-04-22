package javatpoint;

//A number is said to be the Harshad number if it is divisible by the sum of its digit.
public class HarshadNumber{
    
    
    public static void main(String []args){
       System.out.println("Hello World");
       int num=123,n=num,result;
       int sum=0,rem;
       while(num>0){
         rem = num%10;
         sum = sum+rem;
         num = num/10;
       }
       result = n%sum;
       System.out.println(result);
       //Happy number always ends with 1  
       if(result == 0)  
           System.out.println(n + " is a  Harshad number");  
       //Unhappy number ends in a cycle of repeating numbers which contains 4  
       else 
           System.out.println(n + " is not a  Harshad number");   
    }
    
}
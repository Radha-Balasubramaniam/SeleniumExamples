package javatpoint;

public class DisariumNumberWithRange{

    public static void main(String []args){
       System.out.println("Hello World");
       int result;
       
       for(int n=1;n<=100;n++){
           result = sumofDigits(n);
           if(result==n)
           System.out.println(n);
       }
       
       
    }
    
    public static int sumofDigits(int num){
        int sum=0,rem;
       int length = calculatelength(num);
       while(num>0){
         rem = num%10;
         sum = sum+(int)Math.pow(rem,length);
         num = num/10;
         length = length-1;
       }
       
      return sum;
    }
    
    public static int calculatelength(int num){
        
        int length=0;
        
        while(num!=0){
           length = length+1;
           num = num/10;
        }
        return length;
    }
}
package javatpoint;

/* 11 + 72 + 53 = 1 + 49 + 125 = 175
175 is a disarium number*/

public class DisariumNumber{

    public static void main(String []args){
       System.out.println("Hello World");
       int num=175;
       int sum=0,rem;
       int length = calculatelength(num);
       while(num>0){
         rem = num%10;
         sum = sum+(int)Math.pow(rem,length);
         num = num/10;
         length = length-1;
       }
       
       System.out.print(sum);
    }
    
    public static int calculatelength(int num){
        
        int length=0;
        
        while(num!=0){
           length = length+1;
           num = num/10;
        }
        System.out.println(length);
        return length;
    }
}
 //1. You've to display the digits of a number.
   // 2. Take as input "n", the number for which //digits have to be displayed.
  //  3. Print the digits of the number line-wise
import java.util.*;
import java.lang.*;  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner sc=new Scanner(System.in);
    long n=sc.nextInt();
    long count=0;
    long temp=n;
    long mul=1;
    while(n>=10)
    {
       mul=mul*10;
        n=n/10;
        
    }
    
   
    while(mul!=0){
   
    long digit=temp/mul;
    System.out.println(digit);
        temp=temp%mul;

    mul=mul/10;
    
    
        
    }
  }
  }
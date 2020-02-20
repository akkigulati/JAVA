/*1. You are required to display the prime factorization of a number.
    2. Take as input a number n.
    3. Print all its prime factors from smallest to largest.*/
import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int temp=n;
      for(int i=2;i*i<=n;)
      {
         while(temp%i==0)
          {System.out.print(i+" ");
           temp=temp/i;
              
          }
          i++;
      }
      if(temp!=1)
      {
          System.out.println(temp);
      }
     }
    }
//PRIME NUMBER
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
  int a=scn.nextInt();
  
  for(int i=1;i<=a;i++)
  {int flag=0;
        int num=scn.nextInt();
        for(int j=2;j*j<=num;j++)
       { if(num%j==0)
       { System.out.println("not prime");
       
           flag=1;
           break;
       }}
        if(flag==0)
        System.out.println("prime");
           
  }
  }
   }
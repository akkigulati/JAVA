// You've to print all prime numbers between a range. 
import java.util.*;
   
   public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
  int low=scn.nextInt();
  
    int high=scn.nextInt();

  while(low<=high)
  {
      int n=low;
      int isprime=1;
      for(int j=2;j*j<=n;j++){
          if(n%j==0)
          {isprime=0;
      }
          
      }
      if(isprime==1){
      System.out.println(n);
  }
  low++;
  }
  }
   }
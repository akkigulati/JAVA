 //1. You are given a number n.
 // 2. You are given a base b. n is a number on base //b.
 // 3. You are required to convert the number n into //its corresponding value in decimal number system.

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      int num=0;
      int c=1;
      while(n!=0)
      {
          int t=n%10;
          num=num+t*c;
          c=c*b;
          n=n/10;
      }
      return num;
   }
   
  }
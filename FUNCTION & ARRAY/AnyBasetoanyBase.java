/* 1. You are given a number n.
  2. You are given a base b1. n is a number on base b.
  3. You are given another base b2.
  4. You are required to convert the number n of base b1 to a number in base b2.
*/

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b1 = scn.nextInt();
      int b2 = scn.nextInt();
  
      int d = getValue(n, b1, b2);
      System.out.println(d);
   }
   public static int getValueInBase(int n, int b) {
        int count = 0;
        int digit = 0;
        int pos = 1;

        while (n != 0) {





            digit = digit + pos * (n % b);
            n = n / b;
            count++;
            pos *= 10;

        }
        return digit;
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
   public static int getValue(int n, int b1, int b2){
       int interval=getValueIndecimal(n,b1);
       int result=getValueInBase(interval,b2);
       return result;
   
  }
  }
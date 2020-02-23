 /* 1. You are given a base b.
  2. You are given two numbers n1 and n2 of base b.
  3. You are required to subtract n1 from n2 and print the value.
*/

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
        int borrow=b;
        int pos = 1;
        int num = 0;
        int diff=0;
        while (n2 != 0 ) {
            int a = n1 % 10;
            int c = n2 % 10;
            c=c-diff;
            if(c-a<0)
            {
                c=c+borrow;
                diff=1;
            }
           else 
           diff=0;
           
            num = num + pos * (c-a);
            
            pos *= 10;
            n1 /= 10;
            n2 /= 10;
        }

        return num;
    }
   }
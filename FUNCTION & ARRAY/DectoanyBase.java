//1. You are given a decimal number n.
//  2. You are given a base b.
//  3. You are required to convert the number n into //its corresponding value in base b.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int count = 0;
        int digit = 0;
                    int pos = 1;

        while (n != 0) {
      
            digit = digit + pos * (n % b);
            n = n / b;
            count++;
             pos*=10;

        }
        return digit;
    }
}
/*
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
     getValueInBase(n, b);
   //   System.out.println(dn);
   }
  
   public static void getValueInBase(int n, int b){
      int count=0;
     int digit=0;
       while(n!=0)
       { int pos=1;
           
           int a;
          
           for(int i=0;i<count;i++)
           {
               pos=pos*10;
           }
           
           digit=digit+pos*(n%b);
           n=n/b;
           count++;
           
       }
       System.out.println(digit);
   }
  }
*/
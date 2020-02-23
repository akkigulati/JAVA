 /*1. You are given a base b.
  2. You are given two numbers n1 and n2 of base b.
  3. You are required to add the two numbes and print their value in base b.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
        // write ur code here
        int carry = 0;
        int pos = 1;
        int num = 0;
        while (n1 != 0 || n2 != 0 || carry != 0) {
            int a = n1 % 10;
            int d = n2 % 10;
            int c = a + d + carry;
           
           // if (c >= b)
             //   c = c % b;
           carry = c/ b;
           c=c%b;
            num = num + pos * (c);
            
            pos *= 10;
            n1 /= 10;
            n2 /= 10;
        }

        return num;
    }

}
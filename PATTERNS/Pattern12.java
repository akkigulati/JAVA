/*
PATTERN:
0	
1	1	
2	3	5	
8	13	21	34	
55	89	144	233	377	
*/


import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n=scn.nextInt();
         int p=0;
         int k=1;
         int fib=0;
         
         for(int i=0;i<n;i++)
         {  
             for(int j=0;j<=i;j++)
             {
                 
                 System.out.print(p+"	");
                 fib=p+k;
                 p=k;
                 k=fib;
             }
             System.out.println();
         }
          // write ur code here
     
      }
     }
/*
PATTERN:

1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1	
*/

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
         
         int n=scn.nextInt();
         
         int nstar=1;
         int nspace=2*n-3;
         int rows=n;
         int irow=0;
         while(irow<rows-1)
         { int istar=1;
         int variable=nstar;
            //int variable=nstar==rows?nstar-1:nstar;
             while(istar<=variable)
             {    
                 System.out.print(istar+"\t");
                 istar++;
             }
             
             int ispace=1;
             while(ispace<=nspace)
             {
                 System.out.print("\t");
                 ispace++;
             }
             int pstar=istar-1;
             
             while(pstar>=1)
             {
                 System.out.print(pstar+"\t");
                 pstar--;
             }
             System.out.println();
             
             nstar++;
             nspace-=2;
             
             
             irow++;
         }
         
        
            {
                for(int i=1;i<=n;i++)
                 System.out.print(i+"\t");
                 for(int i=n-1;i>0;i--)
                 System.out.print(i+"\t");
            }
       }
      }
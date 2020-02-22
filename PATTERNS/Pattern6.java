/*
PATTERN:

*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*	


*/

import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
           int n=scn.nextInt();
           int nstar=(n/2)+1;
           int nspace=1;
           int rows=n;
           int irow=1;
           while(irow<=rows)
           {
               int istar=1;
               while(istar<=nstar)
               {
                   System.out.print("*	");
                   istar++;
                  
               }
               
               
               int ispace=1;
               while(ispace<=nspace)
               {
                   System.out.print("	");
                   ispace++;
               }
               int pstar=1;
               while(pstar<=nstar)
               {
                   System.out.print("*	");
                   pstar++;
               }
               System.out.println();
               if(irow<n/2+1)
               {  nstar--;
                   nspace=nspace+2;
               }
               else
               {
                   nstar++;
                   nspace=nspace-2;
               }
               
               irow++;
           }
           
       
        }
       }
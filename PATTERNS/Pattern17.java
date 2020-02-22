/*
PATTERN:
		*			
		*	*		
*	*	*	*	*	
		*	*		
		*			
	
*/

import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
           int n=scn.nextInt();
           int nstar=1;
           for(int i=0;i<n;i++)
           { int istar=1;
               for(int j=0;j<n;j++)
               { 
                   if(j>=n/2&&istar<=nstar||i==n/2)
                   {
                   
                   System.out.print("*\t");
                    istar++;
                   }
                    else
                    System.out.print("\t");  
                  }
                  if(i<n/2)
                  nstar++;
                  else
                  nstar--;
               
               System.out.println();
           }
            
       
        }
       }
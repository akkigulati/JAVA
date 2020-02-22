/*
PATTERN:

		*	
	*		*	
*				*	
	*		*	
		*	

*/

import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
                   int n=scn.nextInt();
                   int nspace=((n)/2);
                   int nstar=1;
                   
                   int row=(n);
                   int irow=1;
                   while(irow<=row){
                       int istar=1;
                       int ispace=1;
                       while(ispace<=nspace)
                       {
                           System.out.print("	");
                           ispace+=1;
                       }
                       if(irow<=(n)/2)
                       nspace--;
                       else
                       nspace++;
                       
                       while(istar<=nstar)
                       {   if(istar==nstar||istar==1)
                           System.out.print("*	");
                           else
                           System.out.print("\t");

                           istar=istar+1;
                       }
                       if(irow<=(n)/2)
                       nstar+=2;
                       else
                       nstar-=2;
                    System.out.println();
                    irow++;
                    
                   }
                   
                    // write ur code here
               
                }
               }
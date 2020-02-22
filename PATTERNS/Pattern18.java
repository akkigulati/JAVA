/*
PATTERN:
*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*	

	
*/

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n=scn.nextInt();
          int rows=n;
          int irows=1;
          int nstars=n;
          int nspaces=0;
          
          while(irows<=rows)
          
          {             
              int ispaces=1;
            while(ispaces<=nspaces)
            {
                System.out.print("	");
                ispaces++;
            }

              int istars=1;
              while(istars<=nstars)
              {   if(irows==1||istars==nstars||irows>rows/2||istars==1)
                  {
                      System.out.print("*	");
                  }
                  else
                  System.out.print("	");
                  istars++;
              }
              if(irows<=rows/2){
                  nspaces++;
                  nstars-=2;
              }else
              {
                  nspaces--;
                  nstars+=2;
                  
              }
              System.out.println();
              irows++;
          }
          
      
       }
      }
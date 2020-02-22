/*
PATTERN:
1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	
*/

import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int i=scn.nextInt();
            
          for(int n=0;n<i;n++)
          {int p=1;
         
              for(int r=0;r<=n;r++)
              {   
                  System.out.print(p+"\t");
                  
                  p=((n-r)*p)/(r+1);
                  
                  
                  /* PASCAL TRIANGLE
                  //n factorial
                  //r factorial
                  //n-r factorial
                  
                  int nf=1;
                  for(int i=1;i<=n;i++)
                  nf=nf*i;
                  
                  int rf=1;
                  for(int i=1;i<=r;i++)
                  rf=rf*i;
                  
                  int nrf=1;
                  for(int i=1;i<=n-r;i++)
                  nrf=nrf*i;
                  
                  int val=nf/(rf*nrf);
                  */
                  
                  
              }
              System.out.println();
          }
     
      }
     }
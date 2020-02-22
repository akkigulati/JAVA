/*
PATTERN:

		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	

*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nspace = n / 2;
        int num = 1;
        int row = 1;
        int nrows = n;
        int init=1;
        while (row <=nrows) {
            int ispace = 1;
            while (ispace <= nspace) {
                System.out.print("\t");
                ispace++;
            }
            int tnum = 1;

            int val = init;
            while (tnum <= num) {
                System.out.print(val+"\t");
             
                if (tnum <= num / 2)
                    val++;
                else
                    val--;
                    
                tnum++;
            }
            
            System.out.println();
            if (row <= nrows / 2) {
                num += 2;
                nspace--;
                init++;
                
            } else {
                num -= 2;
                nspace++;
                init--;
            }

            row++;

        }


    }
}
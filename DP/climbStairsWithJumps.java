import java.io.*;
import java.util.*;
/*recursive
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }

        System.out.println(climb(0, jumps));

    }
    public static int climb(int idx, int jumps[]) {
        if (idx == jumps.length-1) {
            return 1;
        }
        int totalways=0;
        int maxJumps = jumps[idx];
       
            for (int i = 1; i <= maxJumps; i++) {
                if (i + idx < jumps.length)
                    totalways += climb(idx + i, jumps);
            }
        
        
        return totalways;
    }

}
*/
/*
memorization
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }

        System.out.println(climb(0, jumps,new int[n]));

    }
    public static int climb(int idx, int jumps[],int dp[]) {
        if (idx == jumps.length-1) {
            dp[idx]=1;
            return 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int totalways=0;
        int maxJumps = jumps[idx];
       
            for (int i = 1; i <= maxJumps; i++) {
                if (i + idx < jumps.length)
                    totalways += climb(idx + i, jumps,dp);
            }
        
        
        return dp[idx]=totalways;



    }

}
*/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jumps[] = new int[n];
        for(int k=0;k<n;k++){
            jumps[k]=sc.nextInt();
        }
        int tab[] = new int[n];
        tab[n-1] = 1;
        for (int i = n-1; i>=0 ; i--) {

            for (int j = 1; j <= jumps[i]; j++)
                if (i + j <= n-1) {
                    tab[i] += tab[i + j];
                }

        }
        System.out.println(tab[0]);
    }
}

/*Question
  1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
                               
                               
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of non-overlapping bridges.
Constraints
0 <= n <= 20
0 <= n1n, n1s, n2n, n2s, .. <= 100
Sample Input
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30
Sample Output
7
*/
/*
import java.io.*;
import java.util.*;

public class Main {
    static class bridge implements Comparable < bridge > {
        int np;
        int sp;
        public int compareTo(bridge o) {
            if (this.np != o.np)
            return this.np-o.np;
            else
            return this.sp-o.sp;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bridge[] barr = new bridge[n];
        for (int i = 0; i < n; i++) {
            barr[i]=new bridge();
            barr[i].np = sc.nextInt();
            barr[i].sp = sc.nextInt();
        }
        Arrays.sort(barr);

        int lis[] = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (barr[i].sp > barr[j].sp && temp <= lis[j]) {
                    temp = lis[j];
                }
            }
            lis[i] = temp + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis[i]);
        }
        System.out.println(max);
    }


}
*/
import java.io.*;
import java.util.*;
//Comparable interface is used to sort user defined datatype with help of compareTo class.
public class Main {
 static class pair implements Comparable < pair > {
    int nb;
    int sb;

    public int compareTo(pair other) {
        if (this.nb != other.nb) {
            return this.nb - other.nb;
        } else {
            return this.sb - other.sb;
        }
    }

}

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pair bridges[] = new pair[n];

        for (int i = 0; i < n; i++) {
            pair bridge = new pair();
            bridge.nb = sc.nextInt();
            bridge.sb = sc.nextInt();
            bridges[i] = bridge;
        }
        Arrays.sort(bridges);

        int[] dp = new int[n];
        //  dp[0]=1
        int ans=Integer.MIN_VALUE;
      
      //appling longest increasing subsequence..
      
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(bridges[j].sb<bridges[i].sb&&max<dp[j]){
                    max=dp[j];
                }
            }
            dp[i]=max+1;
            if(ans<dp[i]){
                ans=dp[i];
            }
        }
        System.out.println(ans);
    }
}

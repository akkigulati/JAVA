/*
Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.
powerSum has the following parameter(s):
X: the integer to sum to
N: the integer power to raise numbers to
Input Format

The first line contains an integer X .
The second line contains an integer n.
Sample Input 0
10
2
Sample Output 0
1
Sample Input 1
100
3
Sample Output 1
1
Explanation:
100=10^2 6^2+8^2 1^2 3^2 4^2 5^2 7^2
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
         return rec(X,N,0,0,1);

    }

    static int rec(int x,int n,int sum,int count,int k){
        if(sum>x||k>x/2){
            return count;
        }
       // System.out.println(k*k);
        if(sum==x){
            count++;
            System.out.println(count);
            return count;
        } 
        int m= rec(x,n,sum,count,k+1);
        int g= rec(x,n,sum+(int)Math.pow(k,n),count,k+1);
       return m+g;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

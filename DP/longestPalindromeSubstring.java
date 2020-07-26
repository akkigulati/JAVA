/*
Question
1. You are given a string str.
2. You are required to print the length of longest of palindromic substrings in string str.
Input Format
A string str
Output Format
A number representing the length of longest of palindromic substrings in string str.
Constraints
0 <= str.length <= 10
Sample Input
abccbc
Sample Output
4

*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n1 = s1.length();
        int dp[][] = new int[n1][n1];
        for (int dia = 0; dia < n1; dia++) {
            for (int i = 0, j = dia; j < n1; j++, i++) {
                if (dia == 0) {
                    dp[i][j] = 1;
                } else if (dia == 1) {
                    if (s1.charAt(i)==s1.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    if (s1.charAt(i)==s1.charAt(j)){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        System.out.println(dp[0][n1-1]);
    }

}
////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int max = 0;
        for (int dia = 0; dia < n; dia++) {
            for (int i = 0, j = dia; j < n; i++, j++) {
                if (dia == 0) {
                    dp[i][j] = true;
                } else if (dia == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]==true) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true) {
                    max = dia + 1;
                }
            }
        }
        System.out.println(max);
    }
}

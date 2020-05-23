/*
Question
     1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
                            
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Maximum gold available.
Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
33
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] gold = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gold[i][j] = sc.nextInt();
            }
        }

        int tab[][] = new int[n][m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    tab[i][j] = gold[i][j];
                } else if (i == 0) {
                    tab[i][j] = gold[i][j] + Math.max(tab[i][j + 1], tab[i + 1][j + 1]);
                } else if (i == n - 1) {
                    tab[i][j] = gold[i][j] + Math.max(tab[i - 1][j + 1], tab[i][j + 1]);
                } else {
                    tab[i][j] = gold[i][j] + Math.max(tab[i][j + 1], Math.max(tab[i + 1][j + 1], tab[i - 1][j + 1]));
                }
            }
        }
        int maxGold = tab[0][0];
        for (int i = 0; i < n; i++) {
            if(maxGold<tab[i][0]){
                maxGold=tab[i][0];
            }
        }
        System.out.println(maxGold);

    }
}

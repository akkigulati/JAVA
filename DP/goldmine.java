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


Recursive:-

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int maze[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        int Profit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           Profit= Math.max(Goldmine(maze,i,0),Profit);
        }
        System.out.println(Profit);
    }
    public static int Goldmine(int[][] gold,int sr,int sc){
        if(sr<0||sr>=gold.length){
            return Integer.MIN_VALUE;
        }
        if(sc==gold[0].length-1){
            return gold[sr][sc];
        }
        return gold[sr][sc]+Math.max(Goldmine(gold,sr,sc+1),Math.max(Goldmine(gold,sr-1,sc+1),Goldmine(gold,sr+1,sc+1)));
    }
}


Memorization:-

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int maze[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        int Profit=Integer.MIN_VALUE;
        int mem[][]=new int[n][m];
        for(int i=0;i<n;i++){
           Profit= Math.max(Goldmine(maze,i,0,mem),Profit);
        }
        System.out.println(Profit);
    }
    public static int Goldmine(int[][] gold,int sr,int sc,int mem[][]){
        if(sr<0||sr>=gold.length){
            return Integer.MIN_VALUE;
        }
        if(sc==gold[0].length-1){
            return mem[sr][sc]=gold[sr][sc];
        }
        if(mem[sr][sc]!=0){
            return mem[sr][sc];
        }
        return mem[sr][sc]=gold[sr][sc]+Math.max(Goldmine(gold,sr,sc+1,mem),Math.max(Goldmine(gold,sr-1,sc+1,mem),Goldmine(gold,sr+1,sc+1,mem)));
    }
}
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

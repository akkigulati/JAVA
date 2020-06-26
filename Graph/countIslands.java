/*
Question
1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
Input Format
Input has been managed for you
Output Format
Number of islands
Constraints
None
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3
*/

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      System.out.println(Island(arr));
   }
    public static int Island(int arr[][]){
        boolean visited[][]=new boolean[arr.length][arr[0].length];
        
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!visited[i][j]&&arr[i][j]==0){
                    gcc(arr,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void gcc(int arr[][],int i,int j,boolean visited[][]){
        if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j]==1||visited[i][j]){
            return;
        }
        visited[i][j]=true;
        gcc(arr,i-1,j,visited);
        gcc(arr,i,j+1,visited);
        gcc(arr,i+1,j,visited);
        gcc(arr,i,j-1,visited);
        
    }
}

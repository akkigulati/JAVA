/*
Question
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. You are required to find and print the k largest elements of array in increasing order.
Input Format
Input is managed for you
Output Format
Print the k largest elements of array in increasing order in separate lines.
Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n
Sample Input
13
12
62
22
15
37
99
11
37
98
67
31
84
99
4
Sample Output
84
98
99
99
*/
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq=new PriorityQueue<>();
//Selection Process
      for (int i = 0; i < n; i++) {
         if(pq.size()<k){
             pq.add(arr[i]);
         }else if(pq.peek()<arr[i]){
             pq.remove();
             pq.add(arr[i]);
         }
      }
      while(pq.size()>0){
          System.out.println(pq.remove());
      }
      
    }

}

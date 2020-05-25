/*
Question
  1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.
e.g.
for the array [6 2 5 4 5 1 6] -> 12                        
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram
Constraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12
*/

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Stack < Integer > st = new Stack < > ();
        int ls[]=new int[n];
        for (int i = 0; i < n; i++) {
            while(st.size()>0&&a[st.peek()]>a[i]){
                st.pop();
            }if(st.size()==0){
                ls[i]=-1;
            }else{
                ls[i]=st.peek();
            }
            st.push(i);
        }
        Stack < Integer > rt = new Stack < > ();
        int rs[]=new int[n];
        for (int i = n-1; i >=0; i--) {
            while(rt.size()>0&&a[rt.peek()]>=a[i]){
                rt.pop();
            }if(rt.size()==0){
                rs[i]=n;
            }else{
                rs[i]=rt.peek();
            }
            rt.push(i);
        }
        int maxArea=0;
        for (int i = 0; i < n; i++) {
            int Area=a[i]*(rs[i]-ls[i]-1);
            if (maxArea<Area)
            maxArea=Area;
        }
        System.out.println(maxArea);
    }
}

/*
Question
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
15
55
39
83
28
13
14
100
32
98
13
87
12
94
39
90

Sample Output
6
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        
        
        int lis[]=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&temp<lis[j]){
                    temp=lis[j];
                }
            }
            lis[i]=temp+1;
        }
        
        int lds[]=new int[n];
        lds[n-1]=1;
        for(int i=n-2;i>=0;i--){
            int temp=0;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]&&temp<lds[j]){
                    temp=lds[j];
                }
            }
            lds[i]=temp+1;
        }
        
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            // System.out.println(lis[i]+" "+lds[i]);
            max=Math.max(max,lis[i]+lds[i]-1);
        }
        System.out.println(max);
        
    }

}


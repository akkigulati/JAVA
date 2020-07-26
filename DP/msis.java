/*
Question
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Input Format
A number n
.. n more elements
Output Format
A number representing the sum of elements of the increasing subsequence with maximum sum for the array.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
1
41

Sample Output
41
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
        lis[0]=arr[0];
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]&&temp<lis[j]){
                    temp=lis[j];
                }
            }
            lis[i]=temp+arr[i];
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,lis[i]);
        }
        System.out.println(max);
        
    }

}

/*
Question
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest increasing subsequence of array.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
1
64

Sample Output
1
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
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,lis[i]);
        }
        System.out.println(max);
        
    }

}




///////////////
import java.util.*;

public class Main{

public static void main(String[] args) {

int arr[]={2,5,3,6};


System.out.println(lis(arr));
 }
 public static int lis(int arr[]){
     int n=arr.length;
     int lis[]=new int[n];
     lis[0]=1;
    for(int i=1;i<n;i++){
        lis[i]=1;
        
        for(int j=0;j<i;j++){
            if(arr[j]<arr[i]){
                lis[i]=Math.max(lis[i],lis[j]+1);
            }
        }
        
    }
    int ans=lis[0];
    for(int i=1;i<n;i++){
        ans=Math.max(ans,lis[i]);
    } 
    return ans;
 }
}
/*
import java.util.*;

public class Main{

public static void main(String[] args) {

int arr[]={4,5,6,3,4,21,32,4,0,1,2,3,4,40};


System.out.println(lis(arr));
 }
 public static int lis(int arr[]){
     int n=arr.length;
     ArrayList<Integer> tail=new ArrayList<>();
     int len=1;
     tail.add(arr[0]);
     for(int i=1;i<n;i++){
         if(arr[i]>tail.get(len-1)){
             //add tail
             tail.add(len,arr[i]);
             
             len++;
         }else{
             //replace tail
             int idx=ceilIdx(tail,0,len-1,arr[i]);
             tail.set(idx,arr[i]);
         }
         
     }
     System.out.println(tail);
     return len;
 }
 public static int ceilIdx(ArrayList<Integer> tail,int l,int r,int val){
     while(r>l){
         int mid=(l+r)/2;
         if(tail.get(mid)>=val){
             r=mid;
         }else{
             l=mid+1;
         }
     }
     return r;
     
 }
}
*/

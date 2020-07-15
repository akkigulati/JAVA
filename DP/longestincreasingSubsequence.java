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

//recursive
import java.util.*;

public class Main{

public static void main(String[] args) {

int arr[]={2,5,3,6};
int tot=10;

System.out.println(coinComb(arr,tot,0,0));

 }
 public static int coinComb(int arr[],int total,int i,int ssf){
     if(ssf>total||i>=arr.length){
         return 0;
     }
     if(ssf==total){
         return 1;
     }
     return coinComb(arr,total,i+1,ssf)+coinComb(arr,total,i,ssf+arr[i]); 
 }
 
}
/*


//dp[i][j] of length i= sum+1 & j=coins.length+1.
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int arr[] = {
           1,2,3
        };
        int n=arr.length;
        int tot = 4;
        int dp[][]=new int[tot+1][n+1];
        
        
        for(int i=1;i<=tot;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }
      
        for(int i=1;i<=tot;i++){
            for(int j=1;j<=n;j++){
                //ignore the jth coin
                dp[i][j]=dp[i][j-1];
                
                if(arr[j-1]<=i){
                    //then include the coin..
                    dp[i][j]+=dp[i-arr[j-1]][j];
                }
            }
        }
        System.out.println(dp[tot][n]);
    }

}
*/

/*MaxCuts of a rod length*/
import java.util.*;

public class Main{

public static void main(String[] args) {

int length=4;
int a=1;
int b=2;
int c=3;

System.out.println(MaxCuts(length,a,b,c));

 }
 static public int MaxCuts(int len,int a,int b,int c){
     int dp[]=new int[len+1];
     dp[0]=0;
     for(int i=1;i<=len;i++){
         dp[i]=-1;
         if(i-a>=0){
             dp[i]=Math.max(dp[i],dp[i-a]);
         }
         if(i-b>=0){
             dp[i]=Math.max(dp[i],dp[i-b]);
         }
         if(i-c>=0){
             dp[i]=Math.max(dp[i],dp[i-c]);
         }
         if(dp[i]!=-1){
             dp[i]=dp[i]+1;
         }
     }
     return dp[len];
 }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int coins[] = {
            25,10,5
        };
        int value = 30;

        System.out.println(minValue(coins, coins.length, value));

    }
    public static int minValue(int[] coins, int n, int val) {
       int dp[]=new int[val+1];
       dp[0]=0;
       for(int i=1;i<=val;i++){
           dp[i]=Integer.MAX_VALUE;
           for(int j=0;j<n;j++){
               if(val-coins[j]>=0){
                   int subRes=dp[val-coins[j]];
                   if(subRes!=Integer.MAX_VALUE)
                   dp[i]=Math.min(dp[i],subRes+1);
               }
           }
       }
        return dp[val];
    }
}

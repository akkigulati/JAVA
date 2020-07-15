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
        if (val == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i: coins) {
            if (i <= val) {
                int subVal = minValue(coins, n, val - i);
                if (subVal != Integer.MAX_VALUE) {
                    res = Math.min(subVal + 1, res);
                }
            }
        }
        return res;
    }
}

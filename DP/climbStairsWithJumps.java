import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jumps[] = new int[n];
        for(int k=0;k<n;k++){
            jumps[k]=sc.nextInt();
        }
        int tab[] = new int[n];
        tab[n-1] = 1;
        for (int i = n-1; i>=0 ; i--) {

            for (int j = 1; j <= jumps[i]; j++)
                if (i + j <= n-1) {
                    tab[i] += tab[i + j];
                }

        }
        System.out.println(tab[0]);
    }
}

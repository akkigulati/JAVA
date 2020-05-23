import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int tab[]=new int[n+1];
        tab[0]=1;
        for(int i=1;i<=n;i++){
            if(i-1>=0){
                tab[i]+=tab[i-1];
            }
            if(i-2>=0){
                tab[i]+=tab[i-2];
            }
            if(i-3>=0){
                tab[i]+=tab[i-3];
            }
        }
        System.out.println(tab[n]);
    }

}

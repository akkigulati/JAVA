import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibT(n));
      //  System.out.println(fibMem(n,new int[n+1]));
         
    }
    public static int fibT(int n){
        int tab[]=new int[n+1];
        tab[0]=0;
        tab[1]=1;
        for(int i=2;i<=n;i++){
            tab[i]=tab[i-1]+tab[i-2];
        }
        return tab[n];
    }
    public static int fibMem(int n,int tab[]){
        if(n==0||n==1){
            return n;
        }else if(tab[n]!=0){
            return tab[n];
        }
        int nm1=fibMem(n-1,tab);
        int nm2=fibMem(n-2,tab);
        tab[n]=nm1+nm2;
        return tab[n];
    }

}
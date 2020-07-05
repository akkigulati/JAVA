import java.util.*;

public class Main{

public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    String s1=sc.nextLine();
    String s2=sc.nextLine();
    int mem[][]=new int[s1.length()+1][s2.length()+1];
    for(int i=0;i<=s1.length();i++){
        for(int j=0;j<=s2.length();j++){
            mem[i][j]=-1;
        }
    }
    System.out.println(lcs(s1,s2,s1.length(),s2.length(),"",mem));
    
 }
 
 //memorization..
 public static int lcs(String s1,String s2,int n,int m,String ans,int mem[][]){
    
     if(mem[n][m]!=-1){
        return mem[n][m];
     } 
     if(n==0||m==0){
         mem[n][m]=0;
     }
   
    else{ if(s1.charAt(n-1)==s2.charAt(m-1)){
         
         mem[n][m]= 1+lcs(s1,s2,n-1,m-1,ans+s1.charAt(n-1),mem);
     }else{
        mem[n][m]= Math.max(lcs(s1,s2,n,m-1,ans,mem),lcs(s1,s2,n-1,m,ans,mem));
     }
    }
     return mem[n][m];
 }
}
/*
import java.util.*;

public class Main{

public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    String s1=sc.nextLine();
    String s2=sc.nextLine();
    int dp[][]=new int[s1.length()+1][s2.length()+1];
    //tabulation
    for(int i=1;i<=s1.length();i++){
        for(int j=1;j<=s2.length();j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1]+1;
            }else{
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
    }
    System.out.println(dp[s1.length()][s2.length()]);
 
}
}
*/

/*
Longest common subsequence of two string.
*/
import java.util.*;

public class Main{

public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    String s1=sc.nextLine();
    String s2=sc.nextLine();
    System.out.println(lcs(s1,s2,s1.length(),s2.length()));
    
 }
 public static int lcs(String s1,String s2,int n,int m){
     if(n==0||m==0){
         return 0;
     }
     if(s1.charAt(n-1)==s2.charAt(m-1)){
         return 1+lcs(s1,s2,n-1,m-1);
     }else{
        return Math.max(lcs(s1,s2,n,m-1),lcs(s1,s2,n-1,m));
     }
     
 }
}

/*
Edit Distance
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n1=s1.length();
        int n2=s2.length();
        
        System.out.println(operations(s1,s2,n1,n2));
        

    }
    public static int operations(String s1,String s2,int n1,int n2){
        if(n1==0){
            return n2;
        }
        if(n2==0){
            return n1;
        }
        
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            return operations(s1,s2,n1-1,n2-1);
        }else{
            return 1+Math.min(operations(s1,s2,n1,n2-1),Math.min(operations(s1,s2,n1-1,n2),operations(s1,s2,n1-1,n2-1)));            
    }
}
}

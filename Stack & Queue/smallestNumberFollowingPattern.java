/*
Question
 1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
                               
Input Format
Input is managed for you
Output Format
Smallest sequence of digits (from 1 to 9) without duplicacy and following the pattern
Constraints
0 < str.length <= 8
str contains only 'd' and 'i'
Sample Input
dddiddd
Sample Output
43218765
*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int count =1;
    String ans="";
    Stack<Integer> st=new Stack<>();
    
    for(int i=0;i<=str.length();i++){
        st.push(count);
        count ++;
        while(st.size()>0&&(i==str.length()||str.charAt(i)=='i')){
            ans+=st.pop();
        }
    }
        System.out.println(ans);
    
 }
}

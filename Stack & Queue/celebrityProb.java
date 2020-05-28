/*
Question
  1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?
                            
Input Format
Input is managed for you  
Output Format
Index of celebrity or none
Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1)
Sample Input
5
01111
10110
11011
00000
00010
Sample Output
3
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        st.push(i);
        
        while(st.size()>1){
            int p1=st.pop();
            int p2=st.pop();
            if(arr[p1][p2]==1){
                st.push(p2);
            }else{
                st.push(p1);
            }
        }
        boolean isCeleb=true;
        int possibleCeleb=st.peek();
        for(int i=0;i<arr.length;i++){
            if(i!=possibleCeleb&&(arr[i][possibleCeleb]==0||arr[possibleCeleb][i]==1))
            {isCeleb=false;
                break;
            }
        }
        if(isCeleb==false){
            System.out.println("none");
        }else{
            System.out.println(possibleCeleb);
        }
        
    }

}

/*
Question
   1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time
                           
                               
Input Format
Input is managed for you 
Output Format
Print a merged meeting start time and end time separated by a space in a line
.. print all merged meetings one in each line.
Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100
Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output
1 12
14 19
22 30
*/
import java.io.*;
import java.util.*;
 
public class Main {
    static class pair implements Comparable < pair > {
    int start;
    int end;

    public int compareTo(pair other) {
        if (this.start != other.start) {
            return this.start - other.start;
        } else {
            return this.end - other.end;
        }
    }

}
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        pair pairs[]=new pair[arr.length];
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            pair cp=new pair();
            cp.start=arr[i][0];
            cp.end=arr[i][1];
            pairs[i]=cp;
        }
        Arrays.sort(pairs);
        Stack<pair> st=new Stack<>();
        st.push(pairs[0]);
        for(int i=1;i<pairs.length;i++){
            pair cp=pairs[i];
            if(st.peek().end>=cp.start){
                st.peek().end=Math.max(cp.end,st.peek().end);
            }else{
                st.push(cp);
            }
        }
        int i=0;
        pair[] ans=new pair[st.size()];
        while(st.size()>0){
            ans[i]=st.pop();
            i++;
        }
        for(int j=ans.length-1;j>=0;j--){
            System.out.println(ans[j].start+" "+ans[j].end);
        }
        
        
    }

}

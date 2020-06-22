/*
Question
 1. You are required to complete the code of our PriorityQueue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data.
2.2. remove -> Should remove and return smallest value, if available or print "Underflow" otherwise and return -1
2.3. peek -> Should return smallest value, if available or print "Underflow" otherwise and return -1
2.4. size -> Should return the number of elements available
3. Input and Output is managed for you.

                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
add 10
add 20
remove
peek
add 30
add 40
remove
peek
peek
add 50
peek
remove
peek
remove
peek
add 60
remove
peek
quit
Sample Output
10
20
20
30
30
30
30
40
40
50
50
60
*/

import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    public void swap(int i1,int i2){
        int temp=data.get(i1);
        int temp2=data.get(i2);
        
        data.set(i1,temp2);
        data.set(i2,temp);
    }
    public void upheapify(int ci){
        if(ci==0){
            return;
        }
        int pi=(ci-1)/2;
        if(data.get(pi)>data.get(ci)){
            swap(ci,pi);
            upheapify(pi);
        }
    }
    public void add(int val) {
        
        data.add(val);
        upheapify(data.size()-1);
    }
    public void downheapify(int pi){
        int lci=2*pi+1;
        int rci=2*pi+2;
        int minIdx=pi;
        
        if(lci<data.size()&&data.get(minIdx)>data.get(lci)){
            minIdx=lci;
        }
        if(rci<data.size()&&data.get(minIdx)>data.get(rci)){
            minIdx=rci;
        }
        if(minIdx!=pi){
            swap(minIdx,pi);
            downheapify(minIdx);
        }
    }
    public int remove() {
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      swap(0,data.size()-1);
      int last=data.remove(data.size()-1);
      downheapify(0);
      return last;
    }

    public int peek() {
        if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

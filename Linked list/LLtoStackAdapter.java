/*
Question
 1. You are required to complete the code of our LLToStackAdapter class. 
2. As data members, you've a linkedlist available in the class.
2. Here is the list of functions that you are supposed to complete
2.1. push -> Should accept new data in LIFO manner
2.2. pop -> Should remove and return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.3. top -> Should return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.4. size -> Should return the number of elements available in the stack
3. Input and Output is managed for you.

Note -> The intention is to use linked list functions to achieve the purpose of a stack. All the functions should work in constant time.

                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
push 10
push 20
pop
top
size
push 30
push 40
push 50
pop
top
size
pop
top
size
quit
Sample Output
20
10
1
50
40
3
40
30
2
*/

import java.io.*;
import java.util.*;

public class Main {

  public static class LLToStackAdapter {
    LinkedList<Integer> list;

    public LLToStackAdapter() {
      list = new LinkedList<>();
    }


    int size() {
        return list.size();
    }

    void push(int val) {
        list.addFirst(val);
    }

    int pop() {
        return list.removeFirst();
    }

    int top() {
        return list.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToStackAdapter st = new LLToStackAdapter();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}

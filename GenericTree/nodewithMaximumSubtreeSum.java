/*Question
 1. You are given a partially written GenericTree class.
2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the concerned subtree separated from node's value by an '@'. Refer the question video for clarity.
3. Input is managed for you. 
                               
Input Format
Input is managed for you
Output Format
@
Constraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
30@130*/
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  static int max;
  static Node maxSumNode;
  public static int sum(Node node){
     // s+=node.data;
     int sum=0;
      for(Node child:node.children){
          int csum=sum(child);
          sum+=csum;
      }
      sum+=node.data;
      if(sum>max){
          max=sum;
          maxSumNode=node;
      }
      return sum;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    maxSumNode=null;
    max=Integer.MIN_VALUE;
    Node root = construct(arr);
    sum(root);
    System.out.println(maxSumNode.data+"@"+max);
  }

}

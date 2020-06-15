/*
Question
1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.
Input Format
Input is managed for you.
Output Format
true if the tree is a BST, false otherwise
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 49 n n 87 n n
Sample Output
false
*/

import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

 public static class BSTpair{
     int min;
     int max;
     boolean isTreeBST;
     
     public BSTpair(){
         min=Integer.MAX_VALUE;
         max=Integer.MIN_VALUE;
         isTreeBST=true;
     }
 }
 public static BSTpair isBST(Node node){
     if(node==null){
         BSTpair base= new BSTpair();
         return base;
     }
     
     BSTpair left=isBST(node.left);
     BSTpair right=isBST(node.right);
     
     boolean nBST=node.data> left.max&&node.data<right.min;
     BSTpair res=new BSTpair();
     
     if(!nBST || !left.isTreeBST || !right.isTreeBST){
         res.isTreeBST=false;
     }
     res.min=Math.min(node.data,Math.min(left.min,right.min));
     res.max=Math.max(node.data,Math.max(left.max,right.max));
 
     return res;
 }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    System.out.println(isBST(root).isTreeBST);
    // write your code here
  }

}

/*
Question
  1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.
                               
                               
Input Format
Input is managed for you.
Output Format
@
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
23
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n 87 n n
Sample Output
25@5
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
//      public static class BSTpair{
//      int min;
//      int max;
//      boolean isTreeBST;
//     //  int size;
//      public BSTpair(){
//          min=Integer.MAX_VALUE;
//          max=Integer.MIN_VALUE;
//          isTreeBST=true;
//         //  size=0;
//      }
//  }
//  static int d;
//  static int bsize;
//  public static BSTpair isBST(Node node){
//      if(node==null){
//          BSTpair base= new BSTpair();
//          return base;
//      }
     
//      BSTpair left=isBST(node.left);
//      BSTpair right=isBST(node.right);
     
//      boolean nBST=node.data> left.max&&node.data<right.min;
//      BSTpair res=new BSTpair();
     
//      if(!nBST || !left.isTreeBST || !right.isTreeBST){
//          res.isTreeBST=false;
//      }
//      res.min=Math.min(node.data,Math.min(left.min,right.min));
//      res.max=Math.max(node.data,Math.max(left.max,right.max));
//      res.size=left.size+right.size+1;
//         if(res.isTreeBST==true&&res.size>bsize){
//             d=node.data;
//             bsize=res.size;
//         }
//      return res;
//  }
public static class BSTpair{
     int min;
     int max;
     boolean isTreeBST;
     int LargestBSTSize; //size of largest bst in tree
     Node LargestBSTroot; //root node of largest bst in a tree.
     public BSTpair(){
         min=Integer.MAX_VALUE;
         max=Integer.MIN_VALUE;
         isTreeBST=true;
         LargestBSTroot=null;
         LargestBSTSize=0;
     }
 }
 public static BSTpair LargestBST(Node node){
     if(node==null){
         BSTpair base= new BSTpair();
         return base;
     }
     
     BSTpair left=LargestBST(node.left);
     BSTpair right=LargestBST(node.right);
     
     boolean nBST=node.data> left.max&&node.data<right.min;
     BSTpair res=new BSTpair();
     
     if(!nBST || !left.isTreeBST || !right.isTreeBST){
         res.isTreeBST=false;
     }
     res.min=Math.min(node.data,Math.min(left.min,right.min));
     res.max=Math.max(node.data,Math.max(left.max,right.max));
        if(res.isTreeBST){
            res.LargestBSTroot=node;
            res.LargestBSTSize=left.LargestBSTSize+right.LargestBSTSize+1;
        }else{
            if(left.LargestBSTSize>=right.LargestBSTSize){
                res.LargestBSTroot=left.LargestBSTroot;
            res.LargestBSTSize=left.LargestBSTSize;
            }else{
                res.LargestBSTroot=right.LargestBSTroot;
            res.LargestBSTSize=right.LargestBSTSize;
                
            }
        }
     return res;
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
    // d=0;
    // bsize=0;
    // isBST(root);
    // System.out.println(d+"@"+bsize);
    // write your code here
    BSTpair ans=LargestBST(root);
    System.out.println(ans.LargestBSTroot.data+"@"+ans.LargestBSTSize);
  }

}

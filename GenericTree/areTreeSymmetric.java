/*
Question
1. You are given a partially written GenericTree class.
2. You are required to complete the body of IsSymmetric function. The function is expected to check if the tree is symmetric, if so return true otherwise return false. For knowing symmetricity think of face and hand. Face is symmetric while palm is not. Also, we are check only smmetricity of shape and not content. Check the question video for clarity.
3. Input and Output is managed for you. 
                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
20
10 20 50 -1 60 -1 -1 30 70 -1 80 -1 90 -1 -1 40 100 -1 110 -1 -1 -1
Sample Output
true
*/
import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
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

    public static int size(Node node) {
        int s = 0;

        for (Node child: node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child: node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child: node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0, j = n2.children.size() - 1; i < n1.children.size() - 1 && j >= 0; i++, j--) {
            Node childn1 = n1.children.get(i);
            Node childn2 = n2.children.get(j);
            if (areMirror(childn1, childn2) == false) {
                return false;
            }
        }
        return true;

    }
    public static boolean IsSymmetric(Node node) {
      return  areMirror(node,node);
    }
/*
    public static boolean check(Node node){
        for(int i=0,j=node.children.size()-1;i<node.children.size()&&j>=0;i++,j--){
            if(node.children.get(i).children.size()!=node.children.get(j).children.size()){
                return false;
            }
        }
        return true;
    }
  public static boolean IsSymmetric(Node node) { 
      if(check(node)==false){
          return false;
      }
    for(Node child:node.children){
        if(IsSymmetric(child)==false){
            return false;
        }
    }
    return true;
  }
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        boolean sym = IsSymmetric(root);
        System.out.println(sym);
        // display(root);
    }

}

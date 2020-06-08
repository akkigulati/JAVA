/*
Question
1. You are given a partially written GenericTree class.
2. You are required to complete the body of lca function. The function is expected to return the lowest common ancestor of two data values that are passed to it. 
Please watch the question video to understand what lca is.
3. Input and Output is managed for you. 
                          
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120
80
Sample Output
80
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

    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList < Integer > path = new ArrayList < > ();
            path.add(node.data);
            return path;
        }

        for (Node child: node.children) {
            ArrayList < Integer > ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList < > ();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList < Integer > first = nodeToRootPath(node, d1);
        ArrayList < Integer > second = nodeToRootPath(node, d2);
        // System.out.println(first);
        // System.out.println(second);
         int ans = 0;
        // for (int i: first) {
            
        //     if (second.contains(i)) {
        //         ans = i;

        //     break;
        //     }
        // }
        for(int i=first.size()-1,j=second.size()-1;i>=0&&j>=0;i--,j--){
            if(first.get(i)==second.get(j)){
                ans=first.get(i);
            }
            else{
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
        // display(root);
    }

}

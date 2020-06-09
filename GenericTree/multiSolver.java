/*
Calculating height, min , max , total & size. 
*/
import java.util.*;
import java.io.*;
public class Main {
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

    static int min;
    static int max;
    static int size;
    static int height;
    static int total;
    public static void multisolver(Node node,int depth){
        size++;
        if(min>node.data){
            min=node.data;
        }
        if(max<node.data){
            max=node.data;
        }
        total+=node.data;
        if(height<depth){
            height=depth;
        }
        for(Node child:node.children){
            multisolver(child,depth+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // boolean sym = IsSymmetric(root);
      //  Node root = construct(arr);
        // boolean sym = IsSymmetric(root);
        height = 0;
        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        total = 0;
        multisolver(root, 0);
        System.out.println("Height :" + height);
        System.out.println("Size :" + size);
        System.out.println("maximum :" + max);
        System.out.println("minimum :" + min);
        System.out.println("totol :" + total);

      //  System.out.println(sym);
        // display(root);
    }
}

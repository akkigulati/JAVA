/*
 ip[] = {
            10,
            20,
            50,
            -1,
            60,
            -1,
            -1,
            30,
            70,
            -1,
            -1,
            40,
            100,
            -1,
            -1,
            -1
        };
        
op:
10 -> 20 30 40 .
20 -> 50 60 .
50 -> .
60 -> .
30 -> 70 .
70 -> .
40 -> 100 .
100 -> .

*/

import java.util.*;

public class Main {
    public static class Node {
        int data;
        ArrayList < Node > childrens = new ArrayList < Node > ();
    }
    public static Node construct(int ip[]) {
        Stack < Node > st = new Stack < > ();
        Node root = new Node();
        root.data = ip[0];
        st.push(root);
        for (int i = 1; i < ip.length; i++) {
            int d = ip[i];
            if (d == -1) {
                st.pop();
            } else {
                Node node = new Node();
                node.data = d;
                //find its parent.. -->st.top();
                Node parent = st.peek();
                //make node ,child of parent
                parent.childrens.add(node);
                st.push(node);
            }

        }
        return root;
    }
    public static void display(Node node) {
        System.out.print(node.data+" -> ");
        for (int i = 0; i < node.childrens.size(); i++) {
            Node child=node.childrens.get(i);
            System.out.print(child.data+" ");
        }
        System.out.println(".");
         for (int i = 0; i < node.childrens.size(); i++) {
            Node child=node.childrens.get(i);
            display(child);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ip[] = {
            10,
            20,
            50,
            -1,
            60,
            -1,
            -1,
            30,
            70,
            -1,
            -1,
            40,
            100,
            -1,
            -1,
            -1
        };
        Node root = construct(ip);
        display(root);
    }
}

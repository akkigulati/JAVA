/*
Construction and display of binary tree.
o/p:
20<-10->30
40<-20->50
.<-40->.
60<-50->.
.<-60->.
.<-30->70
80<-70->90
.<-80->.
.<-90->.

*/
import java.util.*;
import java.io.*;
public class Main {
   public static class Node{
       int data;
       Node left;
       Node right;
       
       Node(int data){
           this.data=data;
           left=null;
           right=null;
       }
       Node(int data,Node lchild,Node rchild){
           this.data=data;
           left=lchild;
           right=rchild;
       }
   }
   public static class pair{
       Node node;
       int state;
       pair(Node node,int state){
           this.node=node;
           this.state=state;
       }
   }
   public static Node construct(Integer input[]){
       Node root= new Node(input[0]);
       Stack<pair> st=new Stack<>();
       st.push(new pair(root,1));
       int idx=1;
       while(st.size()>0){
           pair top=st.peek();
           if(top.state==1){
               Integer val=input[idx];
               if(val!=null){
                   Node node=new Node(val);
                   top.node.left=node;
                   st.push(new pair(node,1));
               }
               else if(val==null){
                   top.node.left=null;
               }
               top.state++;
               idx++;
           }else if(top.state==2){
               Integer val=input[idx];
               if(val!=null){
                   Node node =new Node(val);
                   top.node.right=node;
                   st.push(new pair(node,1));
               }else if(val==null){
                   top.node.right=null;
               }
                top.state++;
                idx++;
           }else if(top.state==3){
               st.pop();
           }
       }
       return root;
       
   }
   public static void display(Node node){
       //self print
       if(node==null){
           //return from invalid spot..
           return;
       }
       String str="";
       if(node.left!=null){
           str+=node.left.data;
       }else{
           str+=".";
       }
       str+="<-"+node.data+"->";
       if(node.right!=null){
           str+=node.right.data;
       }else{
           str+=".";
       }
       System.out.println(str);
       //left node print
       display(node.left);
       //right node print
       display(node.right);
   }
   public static void main(String argv[]){
       Integer ip[]={10,20,40,null,null,50,60,null,null,null,30,null,70,80,null,null,90,null,null};
       Node root=construct(ip);
       display(root);
       
   }
   
}
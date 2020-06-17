/*
25<-40->70
10<-25->30
.<-10->.
.<-30->.
55<-70->90
.<-55->.
.<-90->100
.<-100->.
*/
import java.util.*;
public class Main {
   static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static Node construct(int[] ip,int low,int high){
        
        if(low>high){
            return null;
        }
        
        int mid=(low+high)/2;
        int data=ip[mid];
        Node leftTree=construct(ip,low,mid-1);
        Node rightTree=construct(ip,mid+1,high);
        Node nn=new Node(data,leftTree,rightTree);
        return nn;
        
    }
    public static void display(Node node){
        if(node==null){
            return ;
        }
        String s="";
        if(node.left!=null){
            s=node.left.data+"<-";
        }else{
            s=".<-";
        }
        s+=node.data+"->";
        if(node.right!=null){
            s+=node.right.data;
        }else{
            s+=".";
        }
        System.out.println(s);
        display(node.left);
        display(node.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int input[]={10,25 ,30,40,55,70,90,100};
        
        Node root=construct(input,0,input.length-1);
        display(root);
    }
} 

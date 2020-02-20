/*1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost
   digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
   2. Take as input n and k.
   3. Print the rotated number.
   4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
   n = 12340056
   k = 3
   r = 05612340*/

import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int temp=n;
    int count=0;
    while(temp!=0)
    {
        count++;
        temp/=10;
    }
    int trn=k%count;
    if(k<0)
    trn+=count;
    int div=1,mul=1;
    for(int i=1;i<=count;i++)
    {
        if(i<=trn)
        div*=10;
        else
        mul*=10;
        
    }
    
   int quo=n/div;
   int rem=n%div;
   int merge=(rem*mul)+quo;
    
    System.out.println(merge);
    }
   }
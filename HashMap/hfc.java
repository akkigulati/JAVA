/*
Question
1. You are given a string str.
2. You are required to find the character with maximum frequency.
Input Format
A string str
Output Format
The character with highest frequency
Constraints
0 < str.length() <= 100
There will be a single character with highest frequency
Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Sample Output
q
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        
        HashMap<Character,Integer> ht=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ht.containsKey(ch)){
                //character exists
                int fq=ht.get(ch);
                ht.put(ch,fq+1);
            }else{
                ht.put(ch,1);
            }
        }
        int maxFreq=Integer.MIN_VALUE;
        Character mfc=null;
        for(Character key:ht.keySet()){
            int freq=ht.get(key);
            if(freq>maxFreq){
                maxFreq=freq;
                mfc=key;
            }
        }
        System.out.println(mfc);
    }

}

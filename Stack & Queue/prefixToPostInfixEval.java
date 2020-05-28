/*
Question
 1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

                               
Input Format
Input is managed for you
Output Format
value, a number
infix
prefix
Constraints
1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
-+2/*6483
Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-
*/
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        prefixEval(exp);
       // System.out.println(postfixEval(exp));
    }
    public static void prefixEval(String exp) {
        Stack < Integer > num = new Stack < > ();
        Stack < String > postfix = new Stack < > ();
        Stack < String > infix = new Stack < > ();


        for (int i = exp.length()-1; i >=0 ; i--) {
            char ch = exp.charAt(i);
            if(ch>='0'&&ch<='9'){
                num.push(ch-'0');
                postfix.push(""+ch);
                infix.push(""+ch);
            }
            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                int num1=num.pop();
                int num2=num.pop();
                int ans=solve(ch,num1,num2);
                num.push(ans); 
                String op1=infix.pop();
                String op2=infix.pop();
                infix.push("("+op1+ch+op2+")");
                String post1=postfix.pop();
                String post2=postfix.pop();
                postfix.push(post1+post2+ch);
            }
        }
        System.out.println(num.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
        
    }
    public static int solve(char ch, int num1, int num2) {
        if (ch == '+')
            return num1 + num2;
        else if (ch == '/')
            return num1 / num2;
        else if (ch == '-')
            return num1 - num2;
        else
            return num1 * num2;
    }

}

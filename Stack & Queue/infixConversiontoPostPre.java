/*
Question
 1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
                               
Input Format
Input is managed for you
Output Format
postfix
prefix
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
2 + 6 * 4 / 8 - 3
Sample Output
264*8/+3-
-+2/*6483
*/

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        convert(exp);
        //System.out.println(prefix(ex));
        // code
    }
    public static void convert(String ex) {
        Stack < String > prefix = new Stack < > ();
        Stack < String > postfix = new Stack < > ();
        Stack < Character > op = new Stack < > ();
        for (int i = 0; i < ex.length(); i++) {
          //  System.out.println(i);
            char ch = ex.charAt(i);
            if (isOperand(ch)) {
                prefix.push("" + ch);
                postfix.push("" + ch);
           //     System.out.println(ch);
            } else if (ch == '(') {
                op.push(ch);
            //    System.out.println(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    char oper = op.pop();
                    String preOp2 = prefix.pop();
                    String preOp1 = prefix.pop();
                    prefix.push(oper + preOp1 + preOp2);
                    String postOp2 = postfix.pop();
                    String postOp1 = postfix.pop();
                    postfix.push(postOp1 + postOp2 + oper);
                }
                op.pop();
            } else if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                
                while (op.size() > 0 && op.peek() != '(' && pred(op.peek()) >= pred(ch)) {
                    char oper = op.pop();
                    String preOp2 = prefix.pop();
                    String preOp1 = prefix.pop();
                    prefix.push(oper + preOp1 + preOp2);
                    String postOp2 = postfix.pop();
                    String postOp1 = postfix.pop();
                    postfix.push(postOp1 + postOp2 + oper);
                }
               // System.out.println(ch);
                op.push(ch);
            }
        }
            while (op.size() > 0) {
                char oper = op.pop();
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                prefix.push(oper + preOp1 + preOp2);
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                postfix.push(postOp1 + postOp2 + oper);
            }
            System.out.println(postfix.peek());
            System.out.println(prefix.peek());
    }
    public static boolean isOperand(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

            return true;
        }
        return false;
    }
    public static int pred(char op) {
        if (op == '-' || op == '+')
            return 1;
        else {
            return 2;
        }
    }
}

/*
Question
 1. You are given an infix expression.
2. You are required to evaluate and print it's value.
                               
Input Format
Input is managed for you
Output Format
Value of infix expression
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
2
*/
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        System.out.println(infixEval(exp));
    }
    public static int infixEval(String exp) {
        Stack < Integer > num = new Stack < > ();
        Stack < Character > op = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num.push(ch-'0');
             //   System.out.println(num.peek());
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    //solve
                    char oper = op.pop();
                    int op2 = num.pop();
                    int op1 = num.pop();
                    int ans = solve(oper, op1, op2);
                    num.push(ans);
                }
                op.pop();
            } else if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
              
                while (op.size() > 0 && op.peek() != '(' && pred(op.peek()) >= pred(ch)) {
                    char oper = op.pop();
                    int op2 = num.pop();
                    int op1 = num.pop();
                    int ans = solve(oper, op1, op2);
                    num.push(ans);
                }
                op.push(ch);           
            }
        }
            while (op.size() > 0) {
                char oper = op.pop();
                int op2 = num.pop();
                int op1 = num.pop();
                int ans = solve(oper, op1, op2);
                num.push(ans);
            }
            //System.out.println(num.size());
            return num.peek();
    }
    public static int solve(char op, int num1, int num2) {
        if (op == '-') {
            return num1 - num2;

        } else if (op == '*') {
            return num1 * num2;
        } else if (op == '/') {
            return num1 / num2;
        } else {
            return num1 + num2;
        }
    }
    public static int pred(char op) {
        if (op == '-' || op == '+')
            return 1;
        else {
            return 2;
        }
    }
}

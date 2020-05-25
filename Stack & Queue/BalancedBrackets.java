/*
Question
  1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false
                               
Input Format
A string str
Output Format
true or false
Constraints
0 <= str.length <= 100
Sample Input
[(a + b) + {(c + d) * (e / f)}]
Sample Output
true
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(balBracket(s));

    }
    public static boolean balBracket(String s) {
        Stack < Character > st = new Stack < Character > ();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ')') {
                if (st.size() != 0 && st.peek() == '(')
                    st.pop();
                else {
                    return false;
                }
            } else if (temp == '}') {
                if (st.size() != 0 && st.peek() == '{')
                    st.pop();
                else {
                    return false;
                }
            } else if (temp == ']') {
                if (st.size() != 0 && st.peek() == '[')
                    st.pop();
                else {
                    return false;
                }
            } else if (temp == '(' || temp == '{' || temp == '[') {
                st.push(temp);
            }
        }
        if (st.size() == 0)
            return true;
        else
            return false;


    }
}

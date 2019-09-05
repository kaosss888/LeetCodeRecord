package com.sweartooffer;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String s : tokens) {
            if (!isOperator(s)) {
                stack.push(s);
            } else {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(compute(op1, op2, s)));
            }
        }

        return Integer.parseInt(stack.peek());
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int compute(int op1, int op2, String op) {
        int result = 0;
        switch (op) {
            case "+" :
                result = op1 + op2;
                break;
            case "-" :
                result = op1 - op2;
                break;
            case "*" :
                result = op1 * op2;
                break;
            case "/" :
                result = op1 / op2;
                break;
        }
        return result;
    }
}

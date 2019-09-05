package com.sweartooffer;

import java.util.LinkedList;

public class Calculate {
    public int calculate(String s) {

        LinkedList<Character> op = new LinkedList<>();

        LinkedList<Integer> number = new LinkedList<>();

        int priority = 0;
        StringBuilder op1 = new StringBuilder();
        s = s.replace(" ", "");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (priority == 1) {
                    number.addLast(compute(number.removeLast(), Integer.parseInt(op1.toString()), op.removeLast()));
                } else {
                    number.addLast(Integer.parseInt(op1.toString()));
                }
                op.addLast(s.charAt(i));
                priority = 0;
                op1.delete(0, op1.length());
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (priority == 1) {
                    number.addLast(compute(number.removeLast(), Integer.parseInt(op1.toString()), op.removeLast()));
                } else {
                    number.addLast(Integer.parseInt(op1.toString()));
                }
                op.addLast(s.charAt(i));
                priority = 1;
                op1.delete(0, op1.length());
            } else {
                op1.append(s.charAt(i));
            }

            if (i == s.length() - 1) {
                if (priority == 1) {
                    number.addLast(compute(number.removeLast(), Integer.parseInt(op1.toString()), op.removeLast()));
                } else {
                    number.addLast(Integer.parseInt(op1.toString()));
                }
            }
        }

        while (!op.isEmpty()) {
            int a = number.pop();
            int b = number.pop();
            number.push(compute(a, b, op.pop()));
        }

        return number.getFirst();
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int compute(int op1, int op2, char op) {
        int result = 0;
        switch (op) {
            case '+' :
                result = op1 + op2;
                break;
            case '-' :
                result = op1 - op2;
                break;
            case '*' :
                result = op1 * op2;
                break;
            case '/' :
                result = op1 / op2;
                break;
        }
        return result;
    }
}

package lipo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_逆波兰表达式求值 {

    static Set<String> operator = new HashSet<>();
    static {
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            if (operator.contains(t)) {
                int b = stack.pop();
                int a = stack.pop();

                switch (t) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

}

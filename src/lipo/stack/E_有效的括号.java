package lipo.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_有效的括号 {

    static Map<Character, Character> mapping = new HashMap<>();
    static {
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
    }
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        E_有效的括号 o = new E_有效的括号();
        System.out.println(o.isValid("()"));
        System.out.println(o.isValid("()[]{}"));
        System.out.println(o.isValid("(]"));
        System.out.println(o.isValid("([])"));
        System.out.println(o.isValid("([)]"));
    }
}

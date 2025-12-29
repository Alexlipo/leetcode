package lipo.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_字符串解码 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(sb);
                k = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder str = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    str.append(sb);
                }
                sb = str;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        M_字符串解码 o = new M_字符串解码();
        System.out.println(o.decodeString("3[a]2[bc]"));
        System.out.println(o.decodeString("3[a2[c]]"));
        System.out.println(o.decodeString("2[abc]3[cd]ef"));
        System.out.println(o.decodeString("abc3[cd]xyz"));
    }

}

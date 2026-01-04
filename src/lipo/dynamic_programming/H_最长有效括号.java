package lipo.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_最长有效括号 {

    public int longestValidParentheses_stack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max= Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses_dp(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 &&
                        s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right << 1);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left << 1);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        H_最长有效括号 o = new H_最长有效括号();
        System.out.println(o.longestValidParentheses_stack("(()"));
        System.out.println(o.longestValidParentheses_dp(")()())"));
        System.out.println(o.longestValidParentheses("()(()"));
    }

}

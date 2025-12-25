package lipo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private void backtrack(StringBuilder s, int left, int right, int n, List<String> list) {
        if (s.length() == n << 1) {
            list.add(s.toString());
            return;
        }
        if (left < n) {
            s.append('(');
            backtrack(s, left + 1, right, n, list);
            s.deleteCharAt(s.length() - 1);
        }
        if (right < left) {
            s.append(')');
            backtrack(s, left, right + 1, n, list);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        M_括号生成 o = new M_括号生成();
        System.out.println(o.generateParenthesis(3));
    }

}

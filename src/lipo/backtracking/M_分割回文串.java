package lipo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_分割回文串 {

    boolean[][] f;
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        int len = s.length();
        f = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int i, List<String> list) {
        if (i == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (f[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        M_分割回文串 o = new M_分割回文串();
        System.out.println(o.partition("aab"));
    }

}

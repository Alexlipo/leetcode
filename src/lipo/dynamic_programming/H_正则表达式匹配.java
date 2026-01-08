package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/regular-expression-matching/description/
 */
public class H_正则表达式匹配 {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        // 初始化空字符串匹配模式
        for (int i = 2; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc != '*') {
                    if (pc == '.' || pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // * 匹配 0 次
                    dp[i][j] = dp[i][j - 2];
                    // * 匹配 1 次或多次
                    char pre = p.charAt(j - 2);
                    if (pre == '.' || pre == sc) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }

            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        H_正则表达式匹配 o = new H_正则表达式匹配();
        System.out.println(o.isMatch("aa", "a"));
        System.out.println(o.isMatch("aa", "a*"));
        System.out.println(o.isMatch("ab", ".*"));
    }
}

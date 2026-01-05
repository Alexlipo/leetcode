package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_最长回文子串 {

    public String longestPalindrome_dp(String s) {
        int len = s.length();
        int start = 0;
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > max) {
                        start = j;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindromeLength(s, i, i);
            int len2 = palindromeLength(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        M_最长回文子串 o = new M_最长回文子串();
        System.out.println(o.longestPalindrome("babad"));
        System.out.println(o.longestPalindrome_dp("cbbd"));
    }
}

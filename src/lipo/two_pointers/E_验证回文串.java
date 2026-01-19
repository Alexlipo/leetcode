package lipo.two_pointers;

/**
 * https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_验证回文串 {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) {
                    return false;
                }
            }
        }
        return true;
    }

}

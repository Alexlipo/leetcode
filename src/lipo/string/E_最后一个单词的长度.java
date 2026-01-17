package lipo.string;

/**
 * https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        while (n >= 0 && s.charAt(n) == ' ') {
            n--;
        }
        if (n < 0) {
            return 0;
        }
        int i = n;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return n - i;
    }
}

package lipo.string;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_反转字符串中的单词 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        // 1. 清理空格
        int len = cleanSpace(chars);

        // 2. 整体反转
        reverse(chars, 0, len - 1);

        // 3. 单词反转
        reverseWords(chars, len);

        return new String(chars, 0 ,len);
    }

    private int cleanSpace(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && chars[j] == ' ') {
                j++;
            }
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            if (j < n) {
                chars[i++] = ' ';
            }
        }
        return i > 0 && chars[i - 1] == ' ' ? i - 1 : i;
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char t = chars[l];
            chars[l++] = chars[r];
            chars[r--] = t;
        }
    }

    private void reverseWords(char[] chars, int len) {
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
    }
}

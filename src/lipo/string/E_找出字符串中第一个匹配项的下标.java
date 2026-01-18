package lipo.string;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] next = buildNext(needle);
        int j = 0;

        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] buildNext(String p) {
        int m = p.length();
        int[] next = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        E_找出字符串中第一个匹配项的下标 o = new E_找出字符串中第一个匹配项的下标();
        System.out.println(o.strStr("sssssssssa", "ssssb"));
    }
}

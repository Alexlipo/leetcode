package lipo.substring;

/**
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_最小覆盖子串 {

    public String minWindow(String s, String t) {
        int[] window = new int[58];
        for (int i = 0; i < t.length(); i++) {
            window[t.charAt(i) - 'A']++;
        }
        int l = 0;
        int r = 0;
        String minWindow = "";
        int diff = t.length();
        while (r < s.length()) {
            if (window[s.charAt(r) - 'A']-- > 0) {
                diff--;
            }
            r++;

            while (diff == 0) {
                if (minWindow.isEmpty() || minWindow.length() > r - l) {
                    minWindow = s.substring(l, r);
                }

                if (window[s.charAt(l++) - 'A']++ >= 0) {
                    diff++;
                }
            }
        }
        return minWindow;
    }

    public static void main(String[] args) {
        H_最小覆盖子串 o = new H_最小覆盖子串();
        System.out.println(o.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(o.minWindow("a", "a"));
        System.out.println(o.minWindow("a", "aa"));
    }
}

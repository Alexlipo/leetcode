package lipo.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left++));
            }
            window.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] window = new int[128];
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = window[c];
            if (left < lastIndex) {
                left = lastIndex;
            }
            window[c] = i + 1;
            max = Math.max(i - left + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        M_无重复字符的最长子串 o = new M_无重复字符的最长子串();
        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(o.lengthOfLongestSubstring("bbbbb"));
        System.out.println(o.lengthOfLongestSubstring("pwwkew"));
        System.out.println(o.lengthOfLongestSubstring2(" "));
        System.out.println(o.lengthOfLongestSubstring2("cdd"));
        System.out.println(o.lengthOfLongestSubstring2("abba"));
    }

}

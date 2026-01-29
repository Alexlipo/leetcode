package lipo.hash;

/**
 * https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] == 0) {
                return false;
            }
            hash[c - 'a']--;
        }
        return true;
    }

}

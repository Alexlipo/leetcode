package lipo.hash;

/**
 * https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']++;
        }
        int n = ransomNote.length();
        for (char c : magazine.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                arr[c - 'a']--;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;

    }

}

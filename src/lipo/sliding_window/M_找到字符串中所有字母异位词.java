package lipo.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        char[] charArrS = s.toCharArray();
        char[] charArrP = p.toCharArray();

        int[] arrS = new int[26];
        int[] arrP = new int[26];
        for (int i = 0; i < charArrP.length; i++) {
            arrS[charArrS[i] - 'a']++;
            arrP[charArrP[i] - 'a']++;
        }
        if (arraysEquals(arrS, arrP)) {
            result.add(0);
        }

        for (int i = 0; i < charArrS.length - charArrP.length; i++) {
            arrS[charArrS[i] - 'a']--;
            arrS[charArrS[i + charArrP.length] - 'a']++;

            if (arraysEquals(arrS, arrP)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private boolean arraysEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        char[] charArrS = s.toCharArray();
        char[] charArrP = p.toCharArray();

        int[] arr = new int[26];
        for (int i = 0; i < charArrP.length; i++) {
            arr[charArrS[i] - 'a']++;
            arr[charArrP[i] - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            result.add(0);
        }

        for (int i = 0; i < charArrS.length - charArrP.length; i++) {
            int reduce = charArrS[i] - 'a';
            if (arr[reduce] == 1) {
                diff--;
            } else if (arr[reduce] == 0) {
                diff++;
            }
            arr[reduce]--;

            int add = charArrS[i + charArrP.length] - 'a';
            if (arr[add] == -1) {
                diff--;
            } else if (arr[add] == 0) {
                diff++;
            }
            arr[add]++;

            if (diff == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M_找到字符串中所有字母异位词 o = new M_找到字符串中所有字母异位词();
        System.out.println(o.findAnagrams("cbaebabacd", "abc"));
        System.out.println(o.findAnagrams2("abab", "ab"));
    }

}

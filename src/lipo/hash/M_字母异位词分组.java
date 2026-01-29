package lipo.hash;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int n : count) {
                key.append('#').append(n);
            }
            List<String> v = map.getOrDefault(key.toString(), new ArrayList<>());
            v.add(str);
            map.put(key.toString(), v);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        M_字母异位词分组 o = new M_字母异位词分组();
        System.out.println(o.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(o.groupAnagrams(new String[]{""}));
        System.out.println(o.groupAnagrams(new String[]{"a"}));
        System.out.println(o.groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }

}

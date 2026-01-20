package lipo.two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_判断子序列 {

    public boolean isSubsequence(String s, String t) {
        int ps = 0;
        int pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        return ps == s.length();
    }

    public boolean isSubsequence_advanced(String s, String t) {
        // 构建索引表
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            indexMap.computeIfAbsent(t.charAt(i), _ -> new ArrayList<>()).add(i);
        }

        // 检查单个 s
        int prev = -1;
        for (char c : s.toCharArray()) {
            List<Integer> list = indexMap.get(c);
            if (list == null) {
                return false;
            }

            int p = find(list, prev);
            if (p == list.size()) {
                return false;
            }

            prev = list.get(p);
        }
        return true;
    }

    // 二分查找（找第一个 > target）
    private int find(List<Integer> list, int target) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (list.get(m) <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}

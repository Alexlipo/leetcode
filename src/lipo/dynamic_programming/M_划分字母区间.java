package lipo.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M_划分字母区间 o = new M_划分字母区间();
        System.out.println(o.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(o.partitionLabels("eccbbbbdec"));
    }

}

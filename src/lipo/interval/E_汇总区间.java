package lipo.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_汇总区间 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i];

            // 找连续区间
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                res.add(String.valueOf(start));
            } else {
                res.add(start + "->" + end);
            }

            i++;
        }
        return res;
    }
}

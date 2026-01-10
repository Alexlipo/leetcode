package lipo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/description/
 */
public class M_插入区间 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        // 1. 左边完全不重叠的
        while (i < n && intervals[i][1] < start) {
            result.add(intervals[i++]);
        }
        // 2. 处理重叠区间
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i++][1], end);
        }
        result.add(new int[]{start, end});
        // 3. 右边
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}

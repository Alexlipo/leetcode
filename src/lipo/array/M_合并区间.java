package lipo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_合并区间 {

    public int[][] merge_error(int[][] intervals) {
        long[] arr = new long[(10001 / 64) + 1];
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                int index = i / 64;
                arr[index] |= 1L << (i % 64);
            }
        }
        List<int[]> merge = new ArrayList<>();
        boolean c = false;
        int begin = 0;
        for (int i = 0; i < arr.length; i++) {
            long n = arr[i];
            for (int j = 0; j < 64; j++) {
                if ((n & (1L << j)) != 0) {
                    if (!c) {
                        begin = i * 64 + j;
                    }
                    c = true;
                } else {
                    if (c) {
                        merge.add(new int[]{begin, i * 64 + j - 1});
                    }
                    c = false;
                }
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            int begin = interval[0];
            int end = interval[1];
            if (merge.isEmpty() || merge.getLast()[1] < begin) {
                merge.add(interval);
            } else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], end);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public static void main(String[] args) {
        M_合并区间 o = new M_合并区间();
        System.out.println(Arrays.toString(o.merge(new int[][]{{1,3}, {2,6},{8,10},{15,18}})));
        System.out.println(Arrays.toString(o.merge(new int[][]{{1,4}, {4,5}})));
        System.out.println(Arrays.toString(o.merge(new int[][]{{4,7}, {1,4}})));
        System.out.println(Arrays.toString(o.merge_error(new int[][]{{1,4}, {5,6}})));
    }

}

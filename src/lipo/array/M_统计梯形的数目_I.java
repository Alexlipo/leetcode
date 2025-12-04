package lipo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-number-of-trapezoids-i/description/
 */
public class M_统计梯形的数目_I {

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> heightNum = new HashMap<>();
        for (int[] point : points) {
            heightNum.put(point[1], heightNum.getOrDefault(point[1], 0) + 1);
        }
        int mod = 1000000007;
        long res = 0;
        long sum = 0;
        for (int hNum : heightNum.values()) {
            long edge = (long) hNum * (hNum - 1) / 2;
            res = (res + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        M_统计梯形的数目_I o = new M_统计梯形的数目_I();
        int[][] p1 = new int[][]{new int[]{1,0}, new int[]{2,0}, new int[]{3,0},
                new int[]{2,2}, new int[]{3,2}};
        System.out.println(o.countTrapezoids(p1));

        int[][] p2 = new int[][]{new int[]{0,0}, new int[]{1,0}, new int[]{0,1},
                new int[]{2,1}};
        System.out.println(o.countTrapezoids(p2));
    }
}

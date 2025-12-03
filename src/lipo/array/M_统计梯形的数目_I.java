package lipo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点在笛卡尔平面上的坐标。
 *
 * 水平梯形 是一种凸四边形，具有 至少一对 水平边（即平行于 x 轴的边）。两条直线平行当且仅当它们的斜率相同。
 *
 * 返回可以从 points 中任意选择四个不同点组成的 水平梯形 数量。
 *
 * 由于答案可能非常大，请返回结果对 10^9 + 7 取余数后的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入： points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
 *
 * 输出： 3
 *
 *
 * 有三种不同方式选择四个点组成一个水平梯形：
 *
 * 使用点 [1,0]、[2,0]、[3,2] 和 [2,2]。
 * 使用点 [2,0]、[3,0]、[3,2] 和 [2,2]。
 * 使用点 [1,0]、[3,0]、[3,2] 和 [2,2]。
 * 示例 2：
 *
 * 输入： points = [[0,0],[1,0],[0,1],[2,1]]
 *
 * 输出： 1
 *
 *
 * 只有一种方式可以组成一个水平梯形。
 *
 *
 *
 * 提示：
 *
 * 4 <= points.length <= 105
 * –108 <= xi, yi <= 108
 * 所有点两两不同。
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

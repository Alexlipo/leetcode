package lipo.interval;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 按右端点排序
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 当前气球起点 > 箭的位置 → 打不到
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

}

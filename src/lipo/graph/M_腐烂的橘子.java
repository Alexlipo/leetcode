package lipo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 创建队列用于存储腐烂橘子的坐标，进行BFS遍历
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // 将腐烂橘子的坐标加入队列
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int minutes = 0;
        // 四个方向：上、下、左、右
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // 开始BFS遍历，当队列不为空且还有新鲜橘子时继续
        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();
            // 处理当前层的所有腐烂橘子
            for (int i = 0; i < size; i++) {
                // 从队列中取出一个腐烂橘子的坐标
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 检查四个方向上的相邻单元格
                for (int[] dir : directions) {
                    int nx = r + dir[0], ny = c + dir[1];
                    // 检查新坐标是否在网格范围内且是否是新鲜橘子
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        // 将新鲜橘子变为腐烂状态
                        grid[nx][ny] = 2;
                        // 新鲜橘子数量减一
                        freshCount--;
                        // 将新腐烂的橘子加入队列，用于下一分钟的扩展
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}

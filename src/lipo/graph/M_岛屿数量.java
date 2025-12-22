package lipo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_岛屿数量 {

    public int numIslands_dfs(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands_bfs(char[][] grid) {
        int nums = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                nums++;
                grid[i][j] = '0';
                Queue<Integer> neighbors = new LinkedList<>();
                neighbors.add(i * n + j);
                while (!neighbors.isEmpty()) {
                    Integer index = neighbors.remove();
                    int r = index / n;
                    int c = index % n;
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        neighbors.add((r - 1) * n + c);
                        grid[r - 1][c] = '0';
                    }
                    if (r + 1 < m && grid[r + 1][c] == '1') {
                        neighbors.add((r + 1) * n + c);
                        grid[r + 1][c] = '0';
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        neighbors.add(r * n + c - 1);
                        grid[r][c - 1] = '0';
                    }
                    if (c + 1 < n && grid[r][c + 1] == '1') {
                        neighbors.add(r * n + c + 1);
                        grid[r][c + 1] = '0';
                    }
                }
            }
        }
        return nums;
    }
}

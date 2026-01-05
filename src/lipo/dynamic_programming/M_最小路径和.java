package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_最小路径和 {

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);

            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        M_最小路径和 o = new M_最小路径和();
        System.out.println(o.minPathSum2(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(o.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}

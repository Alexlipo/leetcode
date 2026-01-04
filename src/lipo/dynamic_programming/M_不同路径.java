package lipo.dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_不同路径 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];

    }

    public int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        M_不同路径 o = new M_不同路径();
        System.out.println(o.uniquePaths_dp(3, 7));
        System.out.println(o.uniquePaths(3, 2));
    }
}

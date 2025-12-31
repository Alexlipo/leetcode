package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_打家劫舍 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        M_打家劫舍 o = new M_打家劫舍();
        System.out.println(o.rob(new int[]{1,2,3,1}));
        System.out.println(o.rob(new int[]{2,7,9,3,1}));
    }
    
}

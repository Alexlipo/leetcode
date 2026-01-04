package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_分割等和子集 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n :nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int n :nums) {
            for (int i = target; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        M_分割等和子集 o = new M_分割等和子集();
        System.out.println(o.canPartition(new int[]{1,5,11,5}));
        System.out.println(o.canPartition(new int[]{1,2,3,5}));
    }

}

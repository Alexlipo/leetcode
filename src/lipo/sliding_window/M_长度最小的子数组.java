package lipo.sliding_window;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            // 尝试缩小窗口
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}

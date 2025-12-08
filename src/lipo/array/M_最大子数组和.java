package lipo.array;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_最大子数组和 {

    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int max = nums[0];
        for (int num : nums) {
            preSum = Math.max(preSum + num, num);
            max = Math.max(max, preSum);
        }
        return max;
    }

    public static void main(String[] args) {
        M_最大子数组和 o = new M_最大子数组和();
        System.out.println(o.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(o.maxSubArray(new int[]{1}));
        System.out.println(o.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(o.maxSubArray(new int[]{-2,1}));
    }

}

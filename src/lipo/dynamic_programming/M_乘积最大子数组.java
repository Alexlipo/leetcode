package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tempMax = max;
            max = Math.max(n, Math.max(n * max, n * min));
            min = Math.min(n, Math.min(n * tempMax, n * min));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        M_乘积最大子数组 o = new M_乘积最大子数组();
        System.out.println(o.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(o.maxProduct(new int[]{-2,0,-1}));
    }
}

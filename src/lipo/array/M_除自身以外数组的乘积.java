package lipo.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        M_除自身以外数组的乘积 o = new M_除自身以外数组的乘积();
        System.out.println(Arrays.toString(o.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(o.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

}

package lipo.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_轮转数组 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        M_轮转数组 o = new M_轮转数组();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        o.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{-1,-100,3,99};
        o.rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2));
    }
}

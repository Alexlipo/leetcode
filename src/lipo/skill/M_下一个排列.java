package lipo.skill;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_下一个排列 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int p = n - 2;
        while (p >= 0 && nums[p] >= nums[p + 1]) {
            p--;
        }
        if (p >= 0) {
            int t = n - 1;
            while (nums[t] <= nums[p]) {
                t--;
            }
            swap(nums, p, t);
        }
        reverse(nums, p + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public static void main(String[] args) {
        M_下一个排列 o = new M_下一个排列();
        int[] nums = new int[]{1,3,5,4,2};
        o.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package lipo.skill;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_颜色分类 {

    public void sortColors(int[] nums) {
        int r = 0;
        int b = nums.length - 1;
        int p = 0;
        while (p <= b) {
            if (nums[p] == 0) {
                swap(nums, r++, p++);
            } else if (nums[p] == 1) {
                p++;
            } else {
                swap(nums, p, b--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        M_颜色分类 o = new M_颜色分类();
        int[] nums = new int[]{2,0,2,1,1,0};
        o.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[]{2,0,1};
        o.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}

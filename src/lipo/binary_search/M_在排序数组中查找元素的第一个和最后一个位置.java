package lipo.binary_search;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int r = search(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}

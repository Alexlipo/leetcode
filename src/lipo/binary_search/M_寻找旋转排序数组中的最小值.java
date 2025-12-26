package lipo.binary_search;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            // 最小值在右侧
            if (nums[m] > nums[r]) {
                l = m + 1;
            }
            // 最小值在左侧
            else {
                r = m;
            }
        }
        return nums[l];
    }
}

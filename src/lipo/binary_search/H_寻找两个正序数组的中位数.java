package lipo.binary_search;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        while (l <= r) {
            int i = l + ((r - l) >> 1);
            int j = ((m + n + 1) >> 1) - i;

            int leftMax1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int rightMin1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int leftMax2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int rightMin2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if (((m + n) & 1) == 1) {
                    return Math.max(leftMax1, leftMax2);
                } else {
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                }
            } else if (leftMax1 > rightMin2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        H_寻找两个正序数组的中位数 o = new H_寻找两个正序数组的中位数();
        System.out.println(o.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7,8,9,10,11}));
    }

}

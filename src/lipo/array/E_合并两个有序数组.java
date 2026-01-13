package lipo.array;

/**
 * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 有效尾
        int i = m - 1;
        // nums2 尾
        int j = n - 1;
        // nums1 总尾
        int tail = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[j--];
            }
        }
        // nums2 还有剩余，拷贝进 nums1
        while (j >= 0) {
            nums1[tail--] = nums2[j--];
        }
    }
}

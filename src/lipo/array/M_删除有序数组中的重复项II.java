package lipo.array;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_删除有序数组中的重复项II {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num != nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}

package lipo.array;

/**
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_移除元素 {

    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

}

package lipo.array;

/**
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]);
            if (index <= len) {
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive_recover(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        H_缺失的第一个正数 o = new H_缺失的第一个正数();
        System.out.println(o.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(o.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(o.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(o.firstMissingPositive_recover(new int[]{1,2,0}));
        System.out.println(o.firstMissingPositive_recover(new int[]{3,4,-1,1}));
        System.out.println(o.firstMissingPositive_recover(new int[]{7,8,9,11,12}));
    }

}

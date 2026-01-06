package lipo.skill;

/**
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_多数元素 {

    public int majorityElement(int[] nums) {
        int n = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                n = nums[i];
            }
            count += n == nums[i] ? 1 : -1;
        }
        return n;
    }

    public static void main(String[] args) {
        E_多数元素 o = new E_多数元素();
        System.out.println(o.majorityElement(new int[]{3,2,3}));
        System.out.println(o.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}

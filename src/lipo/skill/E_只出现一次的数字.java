package lipo.skill;

/**
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) {
            r ^= n;
        }
        return r;
    }

    public static void main(String[] args) {
        E_只出现一次的数字 o = new E_只出现一次的数字();
        System.out.println(o.singleNumber(new int[]{2,2,1}));
        System.out.println(o.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(o.singleNumber(new int[]{1}));
    }
}

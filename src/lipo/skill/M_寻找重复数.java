package lipo.skill;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_寻找重复数 {

    public int findDuplicate(int[] nums) {
        int p1 = nums[0];
        int p2 = nums[nums[0]];
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        }
        p1 = 0;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        M_寻找重复数 o = new M_寻找重复数();
        System.out.println(o.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(o.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(o.findDuplicate(new int[]{3,3,3,3,3}));

    }
}

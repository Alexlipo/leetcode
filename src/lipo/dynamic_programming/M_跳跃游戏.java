package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_跳跃游戏 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前下标已经无法到达
            if (i > max) {
                return false;
            }
            // 更新能到达的最远位置
            max = Math.max(max, i + nums[i]);
            // 已经可以到达终点
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        M_跳跃游戏 o = new M_跳跃游戏();
        System.out.println(o.canJump(new int[]{2,3,1,1,4}));
        System.out.println(o.canJump(new int[]{3,2,1,0,4}));
    }

}

package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_跳跃游戏II {

    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            // 到达当前跳跃的边界
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }

}

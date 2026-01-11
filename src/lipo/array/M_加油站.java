package lipo.array;

/**
 * https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 总油量
        int total = 0;
        // 当前油箱
        int curr = 0;
        // 起点
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;
            if (curr < 0) {
                // 说明从 start 到 i 不可能成功
                start = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;

    }

}

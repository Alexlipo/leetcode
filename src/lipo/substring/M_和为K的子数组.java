package lipo.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_和为K的子数组 {
    
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        M_和为K的子数组 o = new M_和为K的子数组();
        //System.out.println(o.subarraySum(new int[]{1,1,1}, 2));
        //System.out.println(o.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(o.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
    }
}

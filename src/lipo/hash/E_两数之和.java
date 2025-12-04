package lipo.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        E_两数之和 o = new E_两数之和();
        System.out.println(Arrays.toString(o.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(o.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(o.twoSum(new int[]{3, 3}, 6)));
    }
}

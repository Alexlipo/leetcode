package lipo.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_存在重复元素II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}

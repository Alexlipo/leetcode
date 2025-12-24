package lipo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_子集 {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets_dfs(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int index) {
        if (nums.length == index) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums, index + 1);
        list.removeLast();
        dfs(nums, index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}

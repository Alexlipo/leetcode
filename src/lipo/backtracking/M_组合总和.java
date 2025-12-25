package lipo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_组合总和 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(), target, candidates, 0);
        return result;
    }

    private void dfs(List<Integer> list, int target, int[] candidates, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(list, target - candidates[i], candidates, i);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        M_组合总和 o = new M_组合总和();
        System.out.println(o.combinationSum(new int[]{2,3,6,7}, 7));
    }

}

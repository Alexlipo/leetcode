package lipo.two_pointers;

import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int tail = nums.length - 1;
            while (tail > i + 1) {
                int target = -(nums[i] + nums[tail]);
                int l = i;
                int r = tail;
                int index = (l + r) >> 1;
                while (index < r && index > l) {
                    if (target == nums[index]) {
                        result.add(Arrays.asList(nums[i], nums[index], nums[tail]));
                        break;
                    } else if (target < nums[index]) {
                        r = index;
                        index = (l + index) >> 1;
                    } else {
                        l = index;
                        index = (index + r) >> 1;
                    }
                }
                while (tail > i + 1 && nums[tail] == nums[tail - 1]) {
                    tail--;
                }
                tail--;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int r = nums.length - 1;
            int l = i + 1;
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (target == sum) {
                    result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (target > sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M_三数之和 o = new M_三数之和();
        System.out.println(o.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(o.threeSum(new int[]{0,1,1}));
        System.out.println(o.threeSum(new int[]{0,0,0,0}));
        System.out.println(o.threeSum2(new int[]{-100,-70,-60,110,120,130,160}));
    }

}

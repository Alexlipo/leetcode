package lipo.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



 * 示例 1：

 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：

 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：

 * 输入：nums = [1,0,1,2]
 * 输出：3


 * 提示：

 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class M_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) {
                continue;
            }
            if (diff == 1) {
                curr++;
            } else {
                max = Math.max(curr, max);
                curr = 1;
            }
        }
        return Math.max(curr, max);
    }

    public static void main(String[] args) {
        M_最长连续序列 o = new M_最长连续序列();
        System.out.println(o.longestConsecutive2(new int[]{100,4,200,1,3,2}));
        System.out.println(o.longestConsecutive2(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(o.longestConsecutive2(new int[]{1,0,1,2}));
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int l = 1;
            int curr = num;

            while (set.contains(++curr)) {
                l++;
            }

            max = Math.max(max, l);
        }
        return max;
    }
}

package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int l = 0;
            int r = size;
            while (l < r) {
                int m = (l + r) >>> 1;
                if (tails[m] < n) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = n;
            if (l == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        M_最长递增子序列 o = new M_最长递增子序列();
        System.out.println(o.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(o.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(o.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

}

package lipo.binary_search;

/**
 * https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int i = l + ((r - l) >> 1);
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return nums[l] < target ? l + 1 : l;
    }

    public static void main(String[] args) {
        E_搜索插入位置 o = new E_搜索插入位置();
        System.out.println(o.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(o.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(o.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(o.searchInsert(new int[]{1,3}, 4));
    }
}

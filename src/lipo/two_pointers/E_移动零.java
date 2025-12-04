package lipo.two_pointers;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_移动零 {

    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] != 0) {
                int t = nums[p2];
                nums[p2] = nums[p1];
                nums[p1++] = t;
            }
            p2++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int p0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i != p0) {
                nums[p0] = nums[i];
                nums[i] = 0;
            }
            p0++;
        }
    }

    public static void main(String[] args) {
        E_移动零 o = new E_移动零();
        int[] arr1 = new int[]{0,1,0,3,12};
        o.moveZeroes2(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{0};
        o.moveZeroes2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}

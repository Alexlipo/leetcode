package lipo.two_pointers;

/**
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_盛最多水的容器 {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        M_盛最多水的容器 o = new M_盛最多水的容器();
        System.out.println(o.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(o.maxArea(new int[]{1,1}));
    }

}

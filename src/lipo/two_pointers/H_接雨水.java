package lipo.two_pointers;

/**
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_接雨水 {

    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                sum += leftMax - height[left++];
            } else {
                sum += rightMax - height[right--];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        H_接雨水 o = new H_接雨水();
        System.out.println(o.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(o.trap(new int[]{4,2,0,3,2,5}));
    }

}

package lipo.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        H_柱状图中最大的矩形 o = new H_柱状图中最大的矩形();
        System.out.println(o.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}

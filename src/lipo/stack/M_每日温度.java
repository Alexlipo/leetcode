package lipo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] dp = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (temperatures[i] < temperatures[j]) {
                    dp[i] = j - i;
                    break;
                }
                if (dp[j] == 0) {
                    dp[i] = 0;
                    break;
                }
                j = j + dp[j];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        M_每日温度 o = new M_每日温度();
        System.out.println(Arrays.toString(o.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}

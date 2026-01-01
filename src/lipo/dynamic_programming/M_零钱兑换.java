package lipo.dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        M_零钱兑换 o = new M_零钱兑换();
        System.out.println(o.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(o.coinChange(new int[]{2}, 3));
        System.out.println(o.coinChange(new int[]{1}, 0));
    }

}

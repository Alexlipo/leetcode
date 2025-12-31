package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int p : prices) {
            min = Math.min(min, p);
            profit = Math.max(profit, p - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        E_买卖股票的最佳时机 o = new E_买卖股票的最佳时机();
        System.out.println(o.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(o.maxProfit(new int[]{7,6,4,3,1}));
    }

}

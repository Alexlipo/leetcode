package lipo.dynamic_programming;

/**
 * https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class E_爬楼梯 {

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;

        }
        return sum;
    }

    public static void main(String[] args) {
        E_爬楼梯 o = new E_爬楼梯();
        System.out.println(o.climbStairs(2));
        System.out.println(o.climbStairs(3));
    }
}

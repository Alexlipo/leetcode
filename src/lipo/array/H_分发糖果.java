package lipo.array;

/**
 * https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class H_分发糖果 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int sum = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int temp = 1;
            if (ratings[i] > ratings[i + 1]) {
                temp = candy[i + 1] + 1;
            }
            sum += Math.max(candy[i], temp);
            candy[i] = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        H_分发糖果 o = new H_分发糖果();
        System.out.println(o.candy(new int[]{1, 0, 2}));
        System.out.println(o.candy2(new int[]{1, 2, 2}));
    }
}

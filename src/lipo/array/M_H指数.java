package lipo.array;

/**
 * https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_H指数 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                arr[n]++;
            } else {
                arr[c]++;
            }
        }
        int c = 0;
        for (int i = n; i > 0; i--) {
            c += arr[i];
            if (c >= i) {
                return i;
            }
        }
        return 0;
    }
}

package lipo.string;

/**
 * https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_罗马数字转整数 {

    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int cur = value(s.charAt(i));

            // 如果后面还有字符，并且当前 < 后一个 → 减
            if (i + 1 < n && cur < value(s.charAt(i + 1))) {
                sum -= cur;
            } else {
                sum += cur;
            }
        }
        return sum;
    }

    private int value(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}

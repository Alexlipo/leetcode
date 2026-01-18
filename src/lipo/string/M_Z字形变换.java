package lipo.string;

/**
 * https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_Z字形变换 {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            // 到顶或到底，改变方向
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }
        // 拼接所有行
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public String convert_math(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        int cycle = (numRows << 1) - 2;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycle) {
                // 竖直向下
                res.append(s.charAt(j + i));
                // 中间行还有斜向上的字符
                if (i != 0 && i != numRows - 1 && j + cycle - i < n) {
                    res.append(s.charAt(j + cycle - i));
                }
            }
        }
        return res.toString();
    }
}

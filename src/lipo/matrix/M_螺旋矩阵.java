package lipo.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/solutions/275393/luo-xuan-ju-zhen-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int left = 0;
        int right = width - 1;
        int top = 0;
        int bottom = height - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        M_螺旋矩阵 o = new M_螺旋矩阵();
        System.out.println(o.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(o.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}

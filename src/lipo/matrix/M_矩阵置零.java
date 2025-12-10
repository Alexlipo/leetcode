package lipo.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int hLen = matrix.length;
        int wLen = matrix[0].length;

        Set<Integer> h0 = new HashSet<>();
        Set<Integer> w0 = new HashSet<>();
        for (int i = 0; i < hLen; i++) {
            for (int j = 0; j < wLen; j++) {
                if (matrix[i][j] == 0) {
                    h0.add(i);
                    w0.add(j);
                }
            }
        }
        for (int h : h0) {
            for (int i = 0; i < wLen; i++) {
                matrix[h][i] = 0;
            }
        }
        for (int w : w0) {
            for (int i = 0; i < hLen; i++) {
                matrix[i][w] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        boolean flagC0 = false;
        for (int i = 0; i < h; i++) {
            if (matrix[i][0] == 0) {
                flagC0 = true;
            }
            for (int j = 1; j < w; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = h - 1; i >= 0; i--) {
            for (int j = 1; j < w; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagC0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        M_矩阵置零 o = new M_矩阵置零();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        o.setZeroes2(matrix);
        System.out.println(Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.toList()));
        int[][] matrix2 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        o.setZeroes2(matrix2);
        System.out.println(Arrays.stream(matrix2).map(Arrays::toString).collect(Collectors.toList()));
    }

}

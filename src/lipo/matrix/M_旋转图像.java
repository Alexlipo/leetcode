package lipo.matrix;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_旋转图像 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int begin = 0;
        int end = n - 1;
        while (begin < end) {
            for (int i = 0; i < end - begin; i++) {
                int temp = matrix[begin][begin + i];
                matrix[begin][begin + i] = matrix[end - i][begin];
                matrix[end - i][begin] = matrix[end][end - i];
                matrix[end][end - i] = matrix[begin + i][end];
                matrix[begin + i][end] = temp;
            }
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        M_旋转图像 o = new M_旋转图像();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        o.rotate(matrix);
        System.out.println(Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.toList()));
        int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        o.rotate(matrix2);
        System.out.println(Arrays.stream(matrix2).map(Arrays::toString).collect(Collectors.toList()));
    }

}

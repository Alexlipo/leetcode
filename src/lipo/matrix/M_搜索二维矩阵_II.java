package lipo.matrix;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_搜索二维矩阵_II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int r = 0;
        int c = width - 1;
        while (r < height && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        M_搜索二维矩阵_II o = new M_搜索二维矩阵_II();
        System.out.println(o.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(o.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(o.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 0));
        System.out.println(o.searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 19));
    }
}

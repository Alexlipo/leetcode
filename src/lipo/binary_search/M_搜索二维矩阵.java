package lipo.binary_search;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int begin = 0;
        int end = m * n - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        M_搜索二维矩阵 o = new M_搜索二维矩阵();
        System.out.println(o.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(o.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 16));
        System.out.println(o.searchMatrix2(new int[][]{{1,3,5},{10,11,16},{23,30,34}}, 10));
        System.out.println(o.searchMatrix2(new int[][]{{1,3,5},{10,11,16},{23,30,34}}, 11));
    }
}

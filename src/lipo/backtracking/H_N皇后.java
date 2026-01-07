package lipo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_N皇后 {

    List<List<String>> res = new ArrayList<>();
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, n);
        return res;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            res.add(construct());
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            // 放皇后
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n);

            // 撤销
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> construct() {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

}

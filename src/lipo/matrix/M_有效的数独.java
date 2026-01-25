package lipo.matrix;

/**
 * https://leetcode.cn/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int mask = 1 << (c - '1');
                int b = (i / 3) * 3 + j / 3;
                if ((row[i] & mask) != 0
                        || (col[j] & mask) != 0
                        || (box[b] & mask) != 0) {
                    return false;
                }
                row[i] |= mask;
                col[j] |= mask;
                box[b] |= mask;
            }
        }
        return true;
    }

}

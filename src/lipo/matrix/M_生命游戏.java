package lipo.matrix;

/**
 * https://leetcode.cn/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_生命游戏 {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[] dirs = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveCount = 0;

                // 遍历 8 个方向
                for (int dx : dirs) {
                    for (int dy : dirs) {
                        if (dx == 0 && dy == 0) continue;

                        int x = i + dx;
                        int y = j + dy;

                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            liveCount += board[x][y] & 1;
                        }
                    }
                }

                // 当前活细胞
                if ((board[i][j] & 1) == 1) {
                    if (liveCount == 2 || liveCount == 3) {
                        board[i][j] |= 2;  // 变为 11（活→活）
                    }
                } else { // 当前死细胞
                    if (liveCount == 3) {
                        board[i][j] |= 2;  // 变为 10（死→活）
                    }
                }
            }
        }

        // 更新到下一状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

}

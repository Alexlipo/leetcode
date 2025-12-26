package lipo.backtracking;

/**
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_单词搜索 {
    boolean[][] visited;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = bfs(board, word, 0, i, j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int i, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        if (i == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        boolean flag = bfs(board, word, i + 1, r - 1, c) ||
                bfs(board, word, i + 1, r + 1, c) ||
                bfs(board, word, i + 1, r, c - 1) ||
                bfs(board, word, i + 1, r, c + 1);
        visited[r][c] = false;
        return flag;
    }

    public static void main(String[] args) {
        M_单词搜索 o = new M_单词搜索();
        System.out.println(o.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(o.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(o.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}

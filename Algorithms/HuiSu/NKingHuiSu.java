package HuiSu;

/**
 * 二叉树前序遍历暴力求解法，回溯优化Version 直接每条路径都尝试，之前走过的不会重复
 */
public class NKingHuiSu {
    public static int count = 0;
    private static int row = 9; // 行
    private static int col = 9; // 列
    public static char[][] chess = new char[row][col];

    // 棋盘初始化
    protected static char[][] init(char[][] chess) {
        for (int i = 0; i < chess.length; i++)
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = '+';
            }
        return chess;
    }

    // 具体算法solve
    protected static void solve(char[][] chess, int row) {
        /**
         * 终止条件
         */
        if (row == chess.length){
            PrintChess(chess);
            count++;
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            // 判断这个位置是否可以放置
            if (valid(chess, row, col)) { //仅当可以放置，我们才进入下一行，当到了最后一行，必定是可以形成一套正确的棋盘
                chess[row][col] = 'Q';
                solve(chess, row + 1);
                chess[row][col] = '+'; // 一旦solve遍历完了
            }
        }
    }

    /**
     * 
     * @param chess 传入当前棋盘
     * @param row   处理的行
     * @param col   处理的列 从0行开始每行遍历
     * @return
     */
    // 判断是否冲突
    protected static boolean valid(char[][] chess, int row, int col) {

        // 判断当前列有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q')
                return false;
        }

        // 判断左上角有没有
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q')
                return false;
        }

        // 判断右上角有没有
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q')
                return false;
        }
        return true;
    }

    // 画棋盘
    public static void PrintChess(char[][] chess) {

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + "   ");
            }
            System.out.println("\n");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        init(chess);
        solve(chess, 0);
        System.out.println(count);
    }
}
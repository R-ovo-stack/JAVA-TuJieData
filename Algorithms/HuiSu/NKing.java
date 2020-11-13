package HuiSu;

/**
 * //此方法会造成大量垃圾
 * 二叉树前序遍历暴力求解法，尚未进行回溯优化Version 直接每条路径都尝试，之前走过的不会重复
 */
public class NKing {
    public static int count=0;
    private static int row = 8; // 行
    private static int col = 8; // 列
    public static char[][] chess = new char[row][col];

    // 棋盘初始化
    protected static char[][] init(char[][] chess) {
        for (int i = 0; i < chess.length; i++)
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = '+';
            }
        return chess;
    }

    //具体算法solve
    protected static void solve(char[][] chess, int row) {
        /**
         * 终止条件
         */
        if (row == chess.length)
            return;
        for (int col = 0; col < chess.length; col++) {
            // 判断这个位置是否可以放置
            if (valid(chess, row, col)) {
                // 如果可以放置
                char[][] temp = copy(chess); // 复制当前棋盘到temp
                temp[row][col] = 'Q';
                solve(temp, row + 1);

                for(int i=0;i<temp.length;i++){
                    if(temp[temp.length-1][i]=='Q'){
                        PrintChess(temp);
                        count++;
                    }
                }

            }
        }
        //PrintChess(chess);
    }

    // 复制当前棋盘
    protected static char[][] copy(char[][] chess) {
        int len = chess.length;
        char[][] temp = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
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
public class TicTacToe {
    private char[][] board;
    private int moves; // 記錄已經走了幾步

    public TicTacToe() {
        board = new char[3][3];
        moves = 0;
        // 初始化盤面為空格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // 玩家設定位置，row和col從0開始
    public boolean setMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false; // 無效位置
        if (board[row][col] != ' ') return false; // 已被占用
        if (player != 'X' && player != 'O') return false; // 非法玩家

        board[row][col] = player;
        moves++;
        return true;
    }

    // 判斷遊戲結果
    public String evaluate() {
        // 檢查行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
                return board[i][0] + " wins";
        }
        // 檢查列
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
                return board[0][j] + " wins";
        }
        // 檢查對角線
        if (board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
            return board[0][0] + " wins";
        if (board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
            return board[0][2] + " wins";

        // 平手
        if (moves == 9) return "Draw";

        // 遊戲尚未結束
        return "Ongoing";
    }

    // 輔助：印出盤面
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%c | %c | %c\n", board[i][0], board[i][1], board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }
}

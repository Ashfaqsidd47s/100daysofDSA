public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ans = queens(board, 5);
        System.out.println(ans);
    }

    public static int queens(boolean[][] board, int row){
        if(row == board.length){
            dispay(board);
            return 1;
        }

        int count = 0;

        //check
        for (int col = 0; col < board.length; col++){

            if(isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col){
        //for vertical check
        for(int i = 0; i< row; i++){
            if (board[i][col]){
                return false;
            }
        }
        //for Right check
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++){
            if (board[row - i][col+ i ]){
                return false;
            }
        }
        //for left check
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if (board[row - i][col - i ]){
                return false;
            }
        }

        return true;
    }

    private static void dispay(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean element : row) {
                if(element) {
                    System.out.print("Q");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Check the edges of the board, and mark all of them as '#'
        for(int i = 0; i<rows; i++) 
            for (int j = 0; j < cols; j++)
                if (i * j == 0 || i == rows - 1 || j == cols - 1)
                    dfs(board, i, j);
                    
        for (char[] row : board)
            for (int i = 0; i < row.length; ++i)
                if (row[i] == '#')
                    row[i] = 'O';
                else if (row[i] == 'O')
                    row[i] = 'X';
    }
    public void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 ||
           i>=board.length || j>=board[0].length ||
           board[i][j] != 'O')return;
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
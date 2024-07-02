class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i =0; i<board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, visited, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, boolean[][] visited, int soFar, int row, int col){
        if(soFar == word.length())
            return true;

        if(row<0 || col<0 || row>=board.length || col>=board[0].length)
            return false;
        
        if(visited[row][col] || (board[row][col] != word.charAt(soFar)))
            return false;
        
        visited[row][col] = true;
        boolean found = backtrack(board, word, visited, soFar+1, row-1, col) || //up
                        backtrack(board, word, visited, soFar+1, row+1, col) || //down
                        backtrack(board, word, visited, soFar+1, row, col-1) || //left
                        backtrack(board, word, visited, soFar+1, row, col+1); //right
        visited[row][col] = false;
        return found;
    }
}
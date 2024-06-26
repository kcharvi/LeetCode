class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
        return islands;
    }
    public void dfs(int i, int j, char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1')return;
        grid[i][j]='2';
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}
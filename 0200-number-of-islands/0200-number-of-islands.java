class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                if(grid[i][j] == '1'){
                    bfs(i, j, grid);
                    islands++;
                }
        return islands;
    }
    public void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '2';
        q.add(new int[]{i,j});
        int rows = grid.length;
        int cols = grid[0].length;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
            for(int[] dir : directions){
                int r = arr[0] + dir[0];
                int c = arr[1] + dir[1];
                if(r>=0 && r<rows && c>=0 && c<cols)
                    if(grid[r][c] == '1'){
                        q.add(new int[]{r,c});
                        grid[r][c] = '2';
                    }
            }
        }
    }
}
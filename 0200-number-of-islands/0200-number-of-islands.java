class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && visited[i][j]==false){
                    bfs(i, j, grid, visited);
                    islands++;
                }
                
            }
        }


        return islands;
    }
    public void bfs(int i, int j, char[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
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
                    if(grid[r][c] == '1' && visited[r][c]==false){
                        q.add(new int[]{r,c});
                        visited[r][c] = true;
                    }
            }
        }
    }
}
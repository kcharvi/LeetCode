class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int total_minutes = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
            
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int qsize = queue.size();
            boolean changed = false;
            for(int i=0; i<qsize; i++){
                int[] current_xy = queue.poll();
                int x = current_xy[0];
                int y = current_xy[1]; 
                
                for(int[] dir: directions){
                    int newx = x+ dir[0];
                    int newy = y+ dir[1];
                    if(isValid(newx, newy, m, n) && 
                       grid[newx][newy] == 1 && 
                       !visited[newx][newy]){
                            grid[newx][newy] = 2;
                            queue.add(new int[]{newx, newy});
                            visited[newx][newy] = true;
                            changed = true;
                    }
                }
            }
            if(changed)
                total_minutes++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return total_minutes;
    }
    boolean isValid(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
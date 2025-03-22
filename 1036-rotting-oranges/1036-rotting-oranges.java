// class Solution {
//     int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
//     public int orangesRotting(int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;

//         int total_minutes = 0;
//         boolean[][] visited = new boolean[m][n];
//         Queue<int[]> queue = new LinkedList<>();
            
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j] == 2){
//                     queue.add(new int[]{i, j});
//                     visited[i][j] = true;
//                 }
//             }
//         }
//         while(!queue.isEmpty()){
//             int qsize = queue.size();
//             boolean changed = false;
//             for(int i=0; i<qsize; i++){
//                 int[] current_xy = queue.poll();
//                 int x = current_xy[0];
//                 int y = current_xy[1]; 
                
//                 for(int[] dir: directions){
//                     int newx = x+ dir[0];
//                     int newy = y+ dir[1];
//                     if(isValid(newx, newy, m, n) && 
//                        grid[newx][newy] == 1 && 
//                        !visited[newx][newy]){
//                             grid[newx][newy] = 2;
//                             queue.add(new int[]{newx, newy});
//                             visited[newx][newy] = true;
//                             changed = true;
//                     }
//                 }
//             }
//             if(changed)
//                 total_minutes++;
//         }
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j] == 1){
//                     return -1;
//                 }
//             }
//         }
//         return total_minutes;
//     }
//     boolean isValid(int x, int y, int m, int n){
//         return x >= 0 && x < m && y >= 0 && y < n;
//     }
// }

class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // directions to check adjacent cells

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int total_minutes = 0;
        boolean hasFresh = true;  // to track if we still have fresh oranges
        
        // Continue looping as long as there are fresh oranges
        while (hasFresh) {
            boolean rottedThisMinute = false;
            hasFresh = false; // reset flag to check if we still have fresh oranges in the next round
            
            // Create a copy of the grid to simulate the new state for this minute
            int[][] newGrid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newGrid[i][j] = grid[i][j];
                }
            }

            // Traverse the grid to check all oranges
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {  // This is a rotten orange
                        // Try to rot the adjacent fresh oranges
                        for (int[] dir : directions) {
                            int newX = i + dir[0];
                            int newY = j + dir[1];
                            if (isValid(newX, newY, m, n) && grid[newX][newY] == 1) {
                                newGrid[newX][newY] = 2;  // This orange rots
                                rottedThisMinute = true;  // At least one orange rotted
                            }
                        }
                    }
                    if (grid[i][j] == 1) {
                        hasFresh = true;  // We still have fresh oranges
                    }
                }
            }

            // After processing the entire grid, update the original grid
            grid = newGrid;

            if (rottedThisMinute) {
                total_minutes++;  // Increment minute if something rotted
            } else {
                break;  // Stop if no new oranges rotted in this minute
            }
        }

        // Check if any fresh oranges are left after all possible rot spread
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;  // There are still fresh oranges that can't rot
                }
            }
        }

        return total_minutes;
    }

    // Check if a position is within bounds of the grid
    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

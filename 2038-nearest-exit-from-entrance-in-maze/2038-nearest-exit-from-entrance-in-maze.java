class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int shortest_path = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        //BFS from current location
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr_location = queue.poll();
                int x = curr_location[0];
                int y = curr_location[1];

                if((x != entrance[0] || y != entrance[1]) &&
                    isExit(x, y, m, n) && 
                    maze[x][y] == '.'){
                        return shortest_path;
                    }

                for(int[] dir: directions){
                    int newx = x+dir[0];
                    int newy = y+dir[1];
                    if(isValid(newx, newy, m, n) &&
                    maze[newx][newy] == '.' &&
                    !visited[newx][newy]
                    ){
                        visited[newx][newy] = true;
                        queue.add(new int[]{newx, newy});
                    }
                }
            }
            shortest_path++;
        }
        
        return -1;
    }
    boolean isExit(int x, int y, int m, int n){
        return x == 0 || y == 0 || x == m - 1 || y == n - 1;
    }
    boolean isValid(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
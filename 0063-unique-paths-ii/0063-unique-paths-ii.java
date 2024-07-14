class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if((obstacleGrid[0][0] + obstacleGrid[m-1][n-1])>0)return 0;
        int[][] dp = new int[m][n];
        for(int i =0; i<m; i++)
            Arrays.fill(dp[i], -1);
        return dfs(0,0, dp, obstacleGrid, m, n);
    }
    int dfs(int i, int j, int[][] dp, int[][] obstacleGrid, int m, int n){
        if(i==m-1 && j==n-1)
            return 1;
        if(i<0 || j<0 || i>=m || j>=n || obstacleGrid[i][j]==1)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j] = dfs(i+1, j, dp, obstacleGrid, m, n)
                 + dfs(i, j+1, dp, obstacleGrid, m, n);
        return dp[i][j];
    }
}
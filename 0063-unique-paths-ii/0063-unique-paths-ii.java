class Solution {
    int m, n, dp[][], obs[][];
    public int uniquePathsWithObstacles(int[][] obs) {
        m = obs.length;
        n = obs[0].length;
        this.obs = obs;
        if(obs[0][0] + obs[m-1][n-1] > 0) return 0;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0);
    }
    int dfs(int i, int j){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i > m-1 || j > n-1 || i < 0 || j < 0 || obs[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] = dfs(i+1, j) + dfs(i, j+1);
        return dp[i][j];
    }
}
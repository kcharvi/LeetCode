class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i<n; i++)
            dp[0][i] = matrix[0][i];
        
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int val = matrix[i][j];
                if(j-1<0 && j+1>=n){
                    dp[i][j] = dp[i-1][j]+val;
                    continue;
                }
                if(j-1 < 0){
                    dp[i][j] = val+Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j+1 >= n){
                    dp[i][j] = val+Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = val+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i: dp[m-1])ans = Math.min(ans,i);
        return ans;
    }
}
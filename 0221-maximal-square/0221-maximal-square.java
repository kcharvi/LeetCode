class Solution {
    public int maximalSquare(char[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
                int max = 0;

        for(int i=0; i<m; i++){
            dp[i][0] = A[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for(int i=0; i<n; i++){
            dp[0][i] = A[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(A[i][j] == '1')
                    {dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);}
            }
        }
        return max*max;
    }
}
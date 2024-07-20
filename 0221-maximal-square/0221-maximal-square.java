class Solution {
    public int maximalSquare(char[][] A) {
        int[][] dp = new int[A.length+1][A[0].length+1];
        int ans=0;
        for(int i=1;i<=A.length;i++){
            for(int j=1; j<=A[0].length; j++){
                if(A[i-1][j-1] == '1'){
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
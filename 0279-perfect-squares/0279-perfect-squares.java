class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    int helper(int n, int[] dp){
        if(dp[n]!=-1)return dp[n];
        if(n==0)return 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            min = Math.min(min, helper(n-i*i, dp)+1);
        }
        dp[n] = min;
        return min;
    }
}
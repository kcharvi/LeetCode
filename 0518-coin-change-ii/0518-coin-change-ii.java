class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n;i++)
            Arrays.fill(dp[i], -1);
        return helper(amount, dp, coins, n-1);
    }
    int helper(int amount, int[][] dp, int[] coins, int n){
        if(n == 0)
            if(amount == 0 || amount%coins[n]==0)return 1;
            else return 0;
        if(dp[n][amount]!=-1)return dp[n][amount];
        int notTaking = helper(amount, dp, coins, n-1);
        int taking = 0;
        if(amount>=coins[n])
            taking = helper(amount-coins[n], dp, coins, n);
        
        return dp[n][amount]=taking + notTaking;
    }
}
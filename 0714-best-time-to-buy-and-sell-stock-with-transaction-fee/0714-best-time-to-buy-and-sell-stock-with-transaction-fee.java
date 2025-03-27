class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int m = prices.length;
        // int[][] dp = new int[m][m];
        // dp[0][0] = -fee;
        // for(int i=1; i<m; i++)
        //     dp[0][i] = (prices[i]-dp[0][0]);
        // for(int i=1; i<m; i++){
        //     for(int j = i; j<m; j++){
        //         dp[i][j] = 
        //     }
        // }
        int n = prices.length;
        int[] buyNow = new int[n];
        int[] sellNow = new int[n];
        int buyMax = -prices[0];
        int sellMax = 0;

        for(int i=1; i<n; i++){
            buyNow[i] = Math.max(buyMax, sellMax - prices[i]);
            sellNow[i] = Math.max(sellMax, buyMax + prices[i] - fee);
            buyMax = Math.max(buyMax, buyNow[i]);
            sellMax = Math.max(sellMax, sellNow[i]);
        }
        return sellNow[n-1];
        
        


    }

}
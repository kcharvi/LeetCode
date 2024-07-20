class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        if(prices.length<=1)return 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxP += prices[i] - prices[i-1];
            }
        }
        return maxP;
    }
}
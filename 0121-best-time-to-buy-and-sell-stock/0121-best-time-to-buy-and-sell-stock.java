class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        int buy = Integer.MAX_VALUE;
        for(int i =0; i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            maxP=Math.max(maxP, prices[i]-buy);
        }
        return maxP;
    }
}
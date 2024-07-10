class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(dp, 0, nums);
    }
    public int rob(int[] dp, int i, int[] nums){
        if(i>= nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        dp[i] = Math.max(rob(dp, i+2, nums) + nums[i], 
                         rob(dp, i+1, nums));
        return dp[i];
        
    }
}
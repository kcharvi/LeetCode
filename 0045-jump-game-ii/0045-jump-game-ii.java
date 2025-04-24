class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // dp = [0, 1, 1, 2, 2] -> dp[i] 
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j] >= i && dp[j] != Integer.MAX_VALUE) //if the current position i is reachable from j and j itself has been reachable
                    dp[i] = Math.min(dp[j]+1, dp[i]); // minimum steps to reach i from j
            }
            
        }
        return dp[nums.length-1];
    }
}
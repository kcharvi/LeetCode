class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;                
        int maxx=0;
        for(int i = 0; i < n; i++)
            maxx = Math.max(maxx, nums[i]);
        
        int[] dp = new int[maxx+1];

        for(int i=0; i<n; i++)  
            dp[nums[i]] += nums[i];

        dp[1] = Math.max(dp[0], dp[1]);
        
        for(int i=2; i<=maxx; i++){
            dp[i] = Math.max(dp[i]+dp[i-2], dp[i-1]);
        }

        return dp[maxx];
        // nums = [2,2,3,3,3,4]
        // dp =   [ 0, 0, 2+2, 3+3+3, 4] 

    }
}
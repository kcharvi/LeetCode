class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0], nums[1]);
        
        // houses from 0 to n-2 (exclude last)
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        int[] dp_ = new int[n+1];
        dp_[1] = nums[1];
        dp_[2] = Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++){
            dp_[i] = Math.max(dp_[i-1], dp_[i-2]+nums[i]);
        }
        return Math.max(dp_[n-1], dp[n-2]);
    }
}
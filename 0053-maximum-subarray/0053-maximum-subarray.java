class Solution {
    public int maxSubArray(int[] nums) {
        int maxInWindow = 0;
        int overallMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxInWindow = Math.max(maxInWindow+nums[i], nums[i]);
            overallMax = Math.max(maxInWindow, overallMax);
        }
        return overallMax;
    }
}
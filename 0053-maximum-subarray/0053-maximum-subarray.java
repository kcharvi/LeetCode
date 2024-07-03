class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndsHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i = 0; i< nums.length; i++){
            maxEndsHere = Math.max(nums[i], maxEndsHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndsHere);
        }
        return maxSoFar;
    }
}
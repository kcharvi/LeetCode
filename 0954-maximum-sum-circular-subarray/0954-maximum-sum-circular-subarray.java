class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEndsHere = 0;
        int maxSoFar = nums[0];
        int minEndsHere = 0;
        int minSoFar = nums[0];
        int totalSum = 0;
        for(int i: nums){
            maxEndsHere = Math.max(i, maxEndsHere+i);
            maxSoFar = Math.max(maxSoFar, maxEndsHere);
            minEndsHere = Math.min(i, minEndsHere+i);
            minSoFar = Math.min(minSoFar, minEndsHere);
            totalSum+=i;
        }
        return maxSoFar>0 ? Math.max(maxSoFar, totalSum-minSoFar): maxSoFar;
    }
}
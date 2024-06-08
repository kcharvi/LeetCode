class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minL=100000000;
        int l=0;
        int r=0;
        int currSum=0;
        while(l<nums.length){
            while(r<nums.length && currSum<target){
                currSum+=nums[r];
                r++;
            }
            if(currSum>=target){
                    minL=Math.min(minL,r-l);
                }
            currSum=currSum - nums[l];
            l++;
        }
        return minL==100000000?0:minL;
    }
}
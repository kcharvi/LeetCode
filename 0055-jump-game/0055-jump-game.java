class Solution {
    public boolean canJump(int[] nums) {
        int coverage=0;
        for(int i=0;i<nums.length;i++){
            if(i>coverage)return false;
            coverage=Math.max(coverage,nums[i]+i);
            if(coverage==nums.length-1)return true;
        }
        return true;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int end = 0;
        int farthest = 0;
        for(int i=0; i<nums.length; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(end == i)
                end = farthest;
            if(end<i)return false;
        }
        return true;
    }
}
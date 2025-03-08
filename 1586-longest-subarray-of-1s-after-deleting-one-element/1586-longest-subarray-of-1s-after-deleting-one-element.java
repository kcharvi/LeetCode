class Solution {
    public int longestSubarray(int[] nums) {
        int cnt0=0;
        int left =0;
        int maxLength=0;
        for(int right =0; right<nums.length; right++){
            if(nums[right] == 0){
                cnt0++;
            }
            while(cnt0>1){
                if(nums[left] == 0)cnt0--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength-1;
    }
}
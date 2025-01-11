class Solution {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length == 1)return 1;
        int currentOR = 0;
        int start =0;
        int end = 0;
        int max_bitwise = 0;
        while(end < nums.length){
            while((currentOR & nums[end]) != 0){
                currentOR ^= nums[start];
                start++;
            }
            currentOR |= nums[end];
            max_bitwise = Math.max(max_bitwise, end - start + 1);
            end++;
        }
        return max_bitwise;
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i: nums)total+=i;
        int leftSum=0;
        for(int i=0; i<n; i++){
            if(leftSum == total-nums[i]-leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
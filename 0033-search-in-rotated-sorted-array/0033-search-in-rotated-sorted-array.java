class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;

        while(l<r){
            int mid = l+(r-l)/2;
            if(target == nums[mid])return mid;
            if(nums[mid]> nums[r])l=mid+1;
            else r=mid;
        }
        int rotation=l;
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int realMid = (mid+rotation)%nums.length;
            if(target == nums[realMid])return realMid;
            if(nums[realMid] < target)l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
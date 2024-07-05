class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[]{-1, -1};
        int l = 0;
        int r = nums.length-1;
        int mid = -1;
        while(l<=r){
            mid = l+ (r-l)/2;
            if(target == nums[mid])break;
            if(target > nums[mid])l=mid+1;
            else r = mid-1;
        }
        if(nums[mid] != target)return new int[]{-1, -1};
        int strt = mid;
        while(strt>=0){
            if(nums[strt] == target)strt--;
            else break;
        }
        int end = mid;
        while(end<nums.length){
            if(nums[end] == target)end++;
            else break;
        }
        return new int[]{strt+1, end-1};
    }
}
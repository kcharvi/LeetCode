class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1 =-1;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] >= target)
                r = mid-1;
            if(nums[mid] < target) 
                l = mid+1;
            if(nums[mid] == target)
               index1 = mid;
        }

        int index2 =-1;
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] <= target)
                l = mid+1;
            if(nums[mid] > target) 
                r = mid-1;
            if(nums[mid] == target)
               index2 = mid;
        }
        return new int[]{index1, index2};
    }
}

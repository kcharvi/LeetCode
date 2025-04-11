class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        // Binary Search for Pivot
        int l = 0;
        int r = n-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] < nums[r])
                r = mid;
            else l = mid + 1;
        }

        // Binary Search for Target
        int pivot = l;
        l = 0;
        r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int realMid = (mid+pivot)%n;
            if(nums[realMid] == target)
                return realMid;
            if(nums[realMid] > target)
                r=mid-1;
            else l = mid+1;
            
        }
        return -1;
    }
}
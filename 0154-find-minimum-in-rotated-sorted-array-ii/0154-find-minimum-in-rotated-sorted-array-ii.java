class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        // Pivot search with duplicates
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--; 
            }
        }
        return nums[l];
    }
}
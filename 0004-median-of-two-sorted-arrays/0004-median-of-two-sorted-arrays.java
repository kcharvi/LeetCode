class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int count = 0; count <= total / 2; count++) {
            prev = curr;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
        
        
        
        //     int m = nums1.length;
        //     int n = nums2.length;

        //     //median of nums1
        //     int l = 0;
        //     int r1 = m-1;
        //     double median1 = 0;
        //     double median2 = 0;
        //     int r2 = n-1;

        //     if(r1==0 || r2==0){
        //         if(r1==0)return medianCalculator(0, r2, nums2);
        //         else return medianCalculator(0, r1, nums1);
        //     }

        //     median1 = medianCalculator(0, r1, nums1);
        //     median2 = medianCalculator(0, r2, nums2);
            
        //     return (double)  (median1+median2)/2;
        // }

        // double medianCalculator(int l, int r, int[] nums){
        //     double median = 0;
        //     if(nums.length == 0)return 0;
        //     if(nums.length == 1)return nums[0];
        //     if(nums.length % 2 == 0){
        //         int mid = l+(r-l)/2;
        //         int mid2 = mid+1;
        //         median = (double)(nums[mid]+nums[mid2])/2;
        //     }
        //     else{
        //         int mid = l+(r-l)/2;
        //         median = (double) nums[mid];
        //     }
        //     return median;
    }
}
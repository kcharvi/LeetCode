class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int mod = 1_000_000_007;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        
        // for(int max_idx = nums.length-1; max_idx>=0; max_idx--){
        //     //Binary search the highest min_val such that sum(min_val, max_val)<=target

        //     int l = 0;
        //     int r = max_idx;
        //     while(l<=r){
        //         int mid = l+(r-l)/2;
        //         if(nums[mid] + nums[max_idx] > target)
        //             r=mid-1;
        //         else l = mid+1;
        //     }
        //     int highest_min_idx = r;
        //     ans+=numberOfSubsequencesPossible(nums, highest_min_idx, max_idx);
        // }

        int l = 0; 
        int r = n-1;
        while(l<=r){
            if(nums[l]+nums[r] <= target){
                ans = (ans + pow[r-l])%mod;
                l++;
            }
            else r--;
        }

        return ans;
    }
    // int numberOfSubsequencesPossible(int[] nums, int i, int j){
    //     int length = j-i;
    //     return 2^length;
    // }
}
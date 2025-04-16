class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        int pairs = 0;
        int l = 0;
        for(int r=0; r<n; r++){
            pairs += map.getOrDefault(nums[r], 0); 
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            
            while(pairs >= k){  //shrink the window from left and remove the freq from map
                map.put(nums[l], map.get(nums[l])-1);
                pairs -= map.get(nums[l]);
                l++;
            }
            ans+=l;
        }
        return ans;        
    }
}
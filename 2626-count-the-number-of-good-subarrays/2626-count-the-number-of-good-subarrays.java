class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        long count_of_pairs = 0;
        int l = 0;
        for(int r=0; r<n; r++){
            int right_val = nums[r];           
            int freq_right_val = map.getOrDefault(right_val, 0);
            count_of_pairs += freq_right_val; 
            map.put(right_val, freq_right_val+1);
            
            while(count_of_pairs >= k){
                ans += n-r;
                int left_val = nums[l];
                int freq_left_val = map.get(left_val);
                map.put(left_val, freq_left_val-1);
                count_of_pairs -= freq_left_val-1;
                l++;
            }

            // for(int r=l+1; r<n; r++){
            //     int curr_right_val = nums[r];

            //     // count the pairs in window l to r   
            //     if(map.containsKey(curr_right_val)){
            //         map.put(curr_right_val, map.get(curr_right_val)+1);
            //         count_of_pairs = map.get(curr_right_val)*(map.get(curr_right_val)-1)/2;
            //     }  
            //     else{
            //         map.put(curr_right_val, 1);
            //     }                           
            //     if(count_of_pairs >= k)
            //         ans++;
            // }
            // if(map.get(curr_left_val) > 1){
            //     map.put(curr_left_val, map.get(curr_left_val)-1);
            // }
            // else{
            //     map.remove(curr_left_val);
            // }
        }
        return ans;        
    }
}
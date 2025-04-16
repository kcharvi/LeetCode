// class Solution {
//     public long countGood(int[] nums, int k) {
//         long ans = 0;
//         int n = nums.length;
//         HashMap<Integer, Integer> map = new HashMap();
//         long count_of_pairs = 0;
//         // Get the first good subarray
//         // Increment l or r based on values being added and count good
//         for(int l=0; l<n-1; l++){
//             int curr_left_val = nums[l];            
//             map.putIfAbsent(curr_left_val, 1);
            
//             for(int r=l+1; r<n; r++){
//                 int curr_right_val = nums[r];

//                 // count the pairs in window l to r   
//                 if(map.containsKey(curr_right_val)){
//                     map.put(curr_right_val, map.get(curr_right_val)+1);
//                     count_of_pairs = map.get(curr_right_val)*(map.get(curr_right_val)-1)/2;
//                 }  
//                 else{
//                     map.put(curr_right_val, 1);
//                 }                           
//                 if(count_of_pairs >= k)
//                     ans++;
//             }
//             if(map.get(curr_left_val) > 1){
//                 map.put(curr_left_val, map.get(curr_left_val)-1);
//             }
//             else{
//                 map.remove(curr_left_val);
//             }
//         }
//         return ans;        
//     }
// }

class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long count_of_pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int freq = map.getOrDefault(val, 0);
            count_of_pairs += freq;
            map.put(val, freq + 1);

            while (count_of_pairs >= k) {
                ans += nums.length - right;
                int leftVal = nums[left];
                int f = map.get(leftVal);
                map.put(leftVal, f - 1);
                count_of_pairs -= (f - 1);
                left++;
            }
        }

        return ans;
    }
}

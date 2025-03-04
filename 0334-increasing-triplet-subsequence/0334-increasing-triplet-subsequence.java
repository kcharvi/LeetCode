class Solution {
    public boolean increasingTriplet(int[] nums) {
        // if(nums.length<3)return false;
        // int[] highest = new int[nums.length];
        // int highestSoFar = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] > highestSoFar){
        //         highestSoFar = nums[i];
        //     }
        //     highest[i] = highestSoFar;
        // }
        // HashSet<Integer> set = new HashSet();
        // for(int i=0; i<highest.length; i++){
        //     if(!set.contains(highest[i])){
        //         set.add(highest[i]);
        //     }
        //     if(set.size()>=3)return true;
        // }
        // return false;


        // int i=Integer.MAX_VALUE;
        // int j=Integer.MAX_VALUE;
        // // int k=0;
        // int minSoFar = Integer.MAX_VALUE;
        // for(int idx=0; idx<nums.length; i++){
        //     if(nums[idx] < minSoFar){
        //         i=idx;
        //     }
        //     if(nums[idx] < nums[i] && nums[idx] < nums[j]){
        //         i = idx;
        //         j = 0;
        //     }
        //     if(nums[idx] > nums[i]){
        //         j=idx;
        //     }
        //     if(nums[idx] < nums[j] && nums[idx] < nums[k]){
        //         j = idx;
        //         k = 0;
        //     }
        //     if(nums[idx] > nums[j]){
        //         k=idx;
        //     }
            
        //     minSoFar = Math.min(minSoFar, nums[idx]);
        // }

        // if(i==-1 || j==-1 || k==-1)return false;
        // else return true;

        if (nums == null || nums.length < 3) {
        return false; // Not enough elements for a triplet
    }
    
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int num : nums) {
        if (num <= first) {
            first = num; // Update the smallest number
        } else if (num <= second) {
            second = num; // Update the second smallest number
        } else {
            return true; // Found a number greater than first and second
        }
    }

    return false;
    }
}
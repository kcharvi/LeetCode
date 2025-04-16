class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3)return 0;
        Arrays.sort(nums);
        int count=0;
        for(int i = 0; i<nums.length-2; i++){
            if(nums[i] == 0)continue;
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i]+nums[j] > nums[k])
                        count++;
                }
            }
        }
        return count;
    }
}
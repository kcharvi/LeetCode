class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int zero_counter = 0;
        for(int i=0; i<nums.length; i++){
            while(i<nums.length-1 && nums[i] == 0){
                i++;
                zero_counter++;
            }
            if(nums[i] != 0){
                nums[idx++] = nums[i];
            }

        }
        if(nums[nums.length-1] == 0)zero_counter++;
        int j=nums.length-1;
        while(zero_counter!=0){
            nums[j] = 0;
            j--;
            zero_counter--;
        }
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt=0;
        int final_len=0;
        int curr_len=0;
        int curr_ele=nums[0];
        for(int i:nums){
            curr_len++;
            if(i==curr_ele){
                cnt++;
                if(cnt<3){
                    final_len++;
                }
            }
            else{
                final_len++;
                curr_ele=i;
                cnt=1;
            }            
            if(final_len<curr_len){
                nums[final_len-1]=i;
            }
        }
        return final_len;
    }

}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length==1)return nums;
        int[] prefix_prod=new int[nums.length];
        int[] sufix_prod=new int[nums.length];
        int prefix=1;
        int sufix=1;
        for(int i=0; i<nums.length;i++){
            prefix=prefix*nums[i];
            sufix=sufix*nums[nums.length-1-i];
            prefix_prod[i]=prefix;
            sufix_prod[nums.length-1-i]=sufix;
        }
        nums[0]=sufix_prod[1];
        nums[nums.length-1]=prefix_prod[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            nums[i]=prefix_prod[i-1]*sufix_prod[i+1];
        }
        return nums;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int ones=0;
        int twice=0; 
        for(int i:nums){
            ones ^= i;
            ones &= ~twice;
            twice ^= i;
            twice &= ~ones;
        }
        return ones;
    }
}
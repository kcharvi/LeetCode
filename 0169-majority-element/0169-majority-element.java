class Solution {
    public int majorityElement(int[] nums) {
        int reward=0;
        int candidate=0;
        for(int i : nums){
            if(reward == 0)candidate=i;
            if(i==candidate)reward++;
            else reward--;
        }
        return candidate;
    }
}
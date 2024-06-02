class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int jumps=0;
        int reach_so_far=0;
        int max_reach=0;
        for(int i =0; i<nums.length-1;i++){
            max_reach=Math.max(max_reach,nums[i]+i);
            if(reach_so_far==i){
                jumps++;
                reach_so_far=max_reach;
            }
        }
        return jumps;

    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0)return ans;
        int l=0;
        for(int i=1;i<=nums.length;i++){
            if(i == nums.length || nums[i] != nums[i - 1] + 1){
                if(l==i-1){
                    ans.add(String.valueOf(nums[l]));
                }
                else{
                    ans.add(nums[l]+"->"+nums[i-1]);
                }
                l = i;
            }
        }

        return ans;
    }
}
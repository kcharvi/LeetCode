class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <3) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for(int i =0; i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1, r =nums.length-1;
            while(l<r){
                int sum = nums[l]+nums [ i ]+nums[r];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;l++;

                    while(l<nums.length && nums[l] ==nums[l-1])l++;
                    while(r>=0 && nums[r] ==nums[r+1])r--;
                }
                else if(sum<0)l++;
                else r--;
            }
        }
        return res;
    }
}
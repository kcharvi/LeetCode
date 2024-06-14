class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        Arrays.sort(nums);
        int maxTillNow=1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    cnt++;
                } else {
                    maxTillNow = Math.max(maxTillNow, cnt);
                    cnt = 1;
                }
            }
        }

        return Math.max(maxTillNow, cnt);
    }
}
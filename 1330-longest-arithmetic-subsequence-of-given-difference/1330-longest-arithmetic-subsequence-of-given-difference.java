class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;
        for (int num : nums) {
            int prev = dp.getOrDefault(num - difference, 0);
            int current = prev + 1;
            dp.put(num, current);
            ans = Math.max(ans, current);
        }
        return ans;
    }
}
import java.util.HashMap;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        // dp[i] will be a map where the key is the difference and the value is the length of the longest arithmetic subsequence ending at index i with that difference.
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                // Length of the longest sequence ending at index j with difference diff, plus 1 (for nums[i])
                int length = dp[j].getOrDefault(diff, 1) + 1;
                // Update dp[i] for this difference
                dp[i].put(diff, length);
                // Update the maximum length found
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
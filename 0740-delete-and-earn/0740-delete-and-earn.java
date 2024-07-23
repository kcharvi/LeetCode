class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        if(n==1) return nums[0];

        // Count occurrences of each number
        HashMap<Integer, Integer> counts = new HashMap();
        for(int i=0; i<n; i++)
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);

        // Extract unique values and sort them
        int size=counts.size();
        int unique[] = new int[size];
        int idx = 0;
        for (int key : counts.keySet())unique[idx++] = key;
        Arrays.sort(unique);

        // Create the dp array
        int[] dp = new int[size];
        dp[0] = unique[0] * counts.get(unique[0]);

        if(size > 1)
            if(unique[1]-1 == unique[0])
                dp[1] = Math.max(dp[0], unique[1]*counts.get(unique[1]));
            else
                dp[1] = dp[0] + unique[1] * counts.get(unique[1]);
        
        for (int i = 2; i < size; i++) {
            int earn1 = dp[i - 1];
            int earn2 = unique[i] * counts.get(unique[i]);
            if (unique[i] == unique[i - 1] + 1) {
                earn2 += dp[i - 2];
            } else {
                earn2 += dp[i - 1];
            }
            dp[i] = Math.max(earn1, earn2);
        }
        return dp[size-1];
    }
}
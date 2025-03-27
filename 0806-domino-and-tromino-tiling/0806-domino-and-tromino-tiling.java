class Solution {
    public int numTilings(int n) {
        // if n = 1 then (1 domino tile - 1 ways)
        // if n = 2 then (2 domino tile - 2 ways)
        // if n = 3 then (3 domino tile - 2 ways) +  (2 trimino tile - 3 ways)
        // if n = 4 then (4 domino tile - 7 ways) + ((2 trimino tile + 1 domino tile) - 4 ways)
        // if n = 5 then (5 domino tile - _ ways) + ((2 trimino tile + 2 domino tile) - _ ways) + (4 trimino tile - _ ways)
        if(n<=2) return n;
        int mod = (int)1e9 + 7;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4; i<=n; i++){
            dp[i] = ((2*dp[i-1])%mod + (dp[i-3])%mod)%mod; 
        }
        return dp[n];
    }
}
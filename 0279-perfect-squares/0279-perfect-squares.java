class Solution {
    public int numSquares(int n) {
        int[] memo = new int[10001];
        Arrays.fill(memo, -1);
        return dp(n, memo);
    }

    private int dp(int num, int[] memo) {
        if (num < 0) return 10000;
        if (num == 0) return 0;
        if (memo[num] != -1) return memo[num];
        int mini = 100000;
        for (int i = 1; i <= 100; i++) {
            mini = Math.min(mini, 1 + dp(num - i * i, memo));
        }
        memo[num] = mini;
        return mini;
    }
}
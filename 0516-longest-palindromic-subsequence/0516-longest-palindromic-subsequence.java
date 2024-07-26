class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] s_arr = s.toCharArray();
        char[] s_rev = new char[n];
        int rev = 0;
        for(int i=n-1;i>=0; i--)
            s_rev[rev++]=s_arr[i]; 
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s_arr[i-1] == s_rev[j-1])    
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
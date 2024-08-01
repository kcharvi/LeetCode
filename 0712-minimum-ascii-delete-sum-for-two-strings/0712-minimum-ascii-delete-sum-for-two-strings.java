class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        //   0   e    a    t
        // 0 0   69   134  218
        // s 115 115  115  115
        // e 184 115  115  115 
        // a 249 

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=n; i++)
            dp[0][i] = dp[0][i-1]+(int)s2.charAt(i-1);
        
        for(int i=1; i<=m; i++)
            dp[i][0] = dp[i-1][0]+(int)s1.charAt(i-1);
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min((int)s1.charAt(i-1) + dp[i-1][j],
                                        (int)s2.charAt(j-1) + dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
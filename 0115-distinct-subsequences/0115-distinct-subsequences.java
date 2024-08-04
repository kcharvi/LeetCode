class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m==0 && n==0)return 1;
        if(m==0) return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            dp[i][n]=1;
        
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(j==n)dp[i][j] = 1;
                if(i==m)dp[i][j] = 0;
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i+1][j+1]+dp[i+1][j]; 
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
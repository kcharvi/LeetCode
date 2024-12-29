class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int[][] dp = new int[n][n];
        int maxLength = 1;
        int strt = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; 
        }
        
        for(int len = 2; len <= n; len++){
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 1;
                    } else if (dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                    if (dp[i][j] == 1 && len > maxLength) {
                        maxLength = len;
                        strt = i;
                    }
                }
            }
        }
        return s.substring(strt, strt+maxLength);
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        String maxString = s.substring(0, 1);

        for(int i=0; i<n; i++)dp[i][i]=true;

        for(int i=0; i<n-1; i++){
            dp[i][i+1]= s.charAt(i)==s.charAt(i+1)? true:false;
            if(dp[i][i+1]){
                maxLen = 2;
                maxString = s.substring(i, i+2);
            }
        }

        for(int len = 3; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(maxLen<len){
                        maxString = s.substring(i,j+1);
                        maxLen = len;
                    }
                }
            }
        }
        return maxString;
    }
}
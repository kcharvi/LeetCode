class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return backtrack(s1,s2,0,0,s3,dp);
    }

    public boolean backtrack(String s1,String s2,int i,int j,String s3,Boolean[][] dp){
        if (i == s1.length() && j == s2.length()){
            return true;
        }

        if (dp[i][j] != null){
            return dp[i][j];
        }

        boolean left = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)){
            left |= backtrack(s1,s2,i + 1,j,s3,dp);
        }

        boolean right = false;
        if (!left && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)){
            right |= backtrack(s1,s2,i,j + 1,s3,dp);
        }
        return dp[i][j] = left || right;
    }
}
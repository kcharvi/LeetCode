class Solution {
    public int maximalSquare(char[][] A) {
        int n=A.length;
        int m=A[0].length;
        int[][] dp = new int[n+1][m+1];
        
        int largest=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(A[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                    largest=Math.max(dp[i][j],largest);
                }                
            }
        }
        return largest*largest;
    }
}
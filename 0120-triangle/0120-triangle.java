class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [] [] dp = new int[n+1][n+1];
        for(int [] ar: dp)Arrays.fill(ar,-1);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(n-1).size();i++){
             ans= Math.min(ans,f(triangle,n-1,i,dp));
        }
        return ans;
    }
    public static int f(List<List<Integer>> arr , int i ,int j , int [][] dp){
        if(j<0 || j>=arr.get(i).size())return (int)1e9;
        if(i==0 && j==0)return arr.get(i).get(j);
        if(dp[i][j]!=-1)return dp[i][j];
        int idx = arr.get(i).get(j)+f(arr,i-1,j,dp);
        int idxm = arr.get(i).get(j)+f(arr,i-1,j-1,dp);
         return dp[i][j] = Math.min(idx,idxm);
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size()-1).size();
        int dp[] = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = triangle.get(triangle.size()-1).get(i);
        
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
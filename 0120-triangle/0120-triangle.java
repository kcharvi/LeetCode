class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int lastline_size = triangle.get(size-1).size();
        int[] dp = new int[lastline_size];
        for(int i=0; i<lastline_size; i++)
            dp[i] = triangle.get(size-1).get(i);
        
        for(int i=size-2; i>=0; i--)
            for(int j=0; j<=i; j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            

        return dp[0];
    }
}
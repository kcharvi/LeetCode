class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int Slen = s.length();
        boolean[] dp = new boolean[Slen+1];
        dp[Slen]=true;

        for(int i=Slen;i>=0; i--){
            for(int j=0; j<wordDict.size(); j++){
                int Wlen = wordDict.get(j).length();
                String W = wordDict.get(j);
                if((i+Wlen) <= Slen && W.equals(s.substring(i, i+Wlen)))
                    dp[i] = dp[i+Wlen];
                if(dp[i])break;
            }
        }
        return dp[0];
    }
}
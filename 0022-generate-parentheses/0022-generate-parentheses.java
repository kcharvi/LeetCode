class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList();
        for(int i=0; i<=n; i++)
            dp.add(new ArrayList());
        
        dp.get(0).add("");

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                List<String> curr = new ArrayList();
                for(String x: dp.get(j))
                    for(String y: dp.get(i-j-1))
                        curr.add("("+x+")"+y);
                dp.get(i).addAll(curr);
            }
        }

        return dp.get(n);   
    }
}
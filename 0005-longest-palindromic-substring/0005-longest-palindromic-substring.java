class Solution {
    public String longestPalindrome(String s) {
        // SOLUTION 1
        // int n = s.length();
        // if(n<=1)return s;
        // String str = s.substring(0,1);
        // int strLen = 1;
        // int maxLen = 1;
        // for(int i = 0; i<n; i++){
        //     int l = i-1;
        //     int r = i+1;
        //     while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
        //         if(r-l+1 > strLen){
        //             strLen = r-l+1;
        //             str = s.substring(l, r+1);
        //         }
        //         l--;
        //         r++;
        //     }

        //     int le = i;
        //     int ri = i+1;
        //     while(le>=0 && ri<n && s.charAt(le) == s.charAt(ri)){
        //         if(ri-le+1 > strLen){
        //             strLen = ri-le+1;
        //             str = s.substring(le, ri+1);
        //         }
        //         le--;
        //         ri++;
        //     }
        // }
        // return str;


        // SOLUTION 2
        int n = s.length();
        if(n<=1)return s;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++)
            dp[i][i] = 1;

        int maxLength = 1;
        String str = s.substring(0,1);

        for (int i = 0; i < n - 1; i++) 
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                if (maxLength < 2) {
                    maxLength = 2;
                    str = s.substring(i, i + 2);
                }
            }
        

        for(int len=3; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    if(maxLength < len){
                        maxLength = len;
                        str = s.substring(i, j+1);
                    }
                }
            }
        }
        return str;
    }
}
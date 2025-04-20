class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1)return s;
        String str = s.substring(0,1);
        int strLen = 1;
        int maxLen = 1;
        for(int i = 0; i<n; i++){
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > strLen){
                    strLen = r-l+1;
                    str = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            int le = i;
            int ri = i+1;
            while(le>=0 && ri<n && s.charAt(le) == s.charAt(ri)){
                if(ri-le+1 > strLen){
                    strLen = ri-le+1;
                    str = s.substring(le, ri+1);
                }
                le--;
                ri++;
            }
        }
        return str;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        String ans = "";
        int n = s.length();
        for(int i = 0; i<n; i++){
            //odd length
            int l=i;
            int r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1) > resLen){
                    ans = s.substring(l, r+1);
                    resLen = r-l+1;
                }
                l-=1;
                r+=1;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1) > resLen){
                    ans = s.substring(l, r+1);
                    resLen = r-l+1;
                }
                l-=1;
                r+=1;
            }
        }
        return ans;
    }
}
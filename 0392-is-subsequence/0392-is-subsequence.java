class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if(s.length() == 0)return true;
        if(s.length() > t.length()){
            return false;
        }
        int subsequence = 0;
        while(i<t.length()){
            if(subsequence <= s.length()-1){
                if(s.charAt(subsequence) == t.charAt(i)){
                    subsequence++;
                }            
            }
            i++;
        }
        if(subsequence == s.length() )return true;
        return false;
    }
}
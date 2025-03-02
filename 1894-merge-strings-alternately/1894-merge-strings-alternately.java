class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        int n = word1.length();
        int m = word2.length();
        StringBuilder ans = new StringBuilder();
        while(i<n && j<m){
            ans.append(word1.charAt(i));
            i++;
            ans.append(word2.charAt(j));
            j++;
        }
        if(i!=n){
            ans.append(word1.substring(i));
        }
        if(j!=m){
            ans.append(word2.substring(j));
        }
        return ans.toString();
    }
}
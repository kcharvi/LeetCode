class Solution {
    public int lengthOfLastWord(String s) {
        if(s ==null)return 0;
        String[] ans=s.split("\\s+");
        return ans[ans.length-1].length();
    }
}
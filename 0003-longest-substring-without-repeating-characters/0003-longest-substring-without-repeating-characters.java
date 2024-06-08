class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)return 0;
        if(n==1)return 1;
        Set<Character> set = new HashSet<>();
        int ans = 0; 
        int i = 0; 
        int j = 0;
        while (j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            //Remove from the current window pop i till the window becomes unique...
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
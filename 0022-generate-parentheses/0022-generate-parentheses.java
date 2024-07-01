class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(0, 0, n, ans, "");
        return ans;
    }
    public void backtrack(int opencount, int closecount, int n, List<String> ans, String curr){
        if(curr.length()==2*n)
            ans.add(curr);
        
        if(opencount<n){
            backtrack(opencount+1, closecount, n, ans, curr+"(");
        }
        if(closecount<opencount){
            backtrack(opencount, closecount+1, n, ans, curr+")");
        }
    }
}
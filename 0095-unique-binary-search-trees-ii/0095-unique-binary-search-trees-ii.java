/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper_generated(1, n);
    }
    public List<TreeNode> helper_generated(int start, int end){
        List<TreeNode> ans = new ArrayList();
        if(start > end){
            ans.add(null);
            return ans;
        }
        
        for(int i=start; i<=end; i++){
            List<TreeNode> lefttree = helper_generated(start, i-1);
            List<TreeNode> righttree = helper_generated(i+1, end);

            for(TreeNode l: lefttree){
                for(TreeNode r: righttree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
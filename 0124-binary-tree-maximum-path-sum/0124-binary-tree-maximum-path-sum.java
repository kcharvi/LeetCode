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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }
    public int maxPathSumHelper(TreeNode root){
        if(root == null)return Integer.MIN_VALUE;
        int l=maxPathSumHelper(root.left);
        int r=maxPathSumHelper(root.right);
        if(l<0)l=0;
        if(r<0)r=0;
        ans = Math.max(ans, l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}
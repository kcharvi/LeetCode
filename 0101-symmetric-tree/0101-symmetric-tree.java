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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return checkLR(root.left,root.right);
    }
    public boolean checkLR(TreeNode l, TreeNode r){
        if(l ==null && r== null)return true;
        if(l==null || r == null)return false;
        if(l.val!=r.val)return false;
        return checkLR(l.left,r.right) && checkLR(l.right, r.left);
    }
}
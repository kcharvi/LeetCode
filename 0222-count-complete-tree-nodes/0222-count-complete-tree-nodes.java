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
    public int countNodes(TreeNode root) {
       if(root==null)return 0;
       int l=0, r=0;
       if(root.left != null)
            l = countNodes(root.left);
       if(root.right != null)
            r = countNodes(root.right);
       return l+r+1;
    }
}
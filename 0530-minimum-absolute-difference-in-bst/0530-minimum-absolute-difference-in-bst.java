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
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        exploreTree(root);
        return min;
    }
    public void exploreTree(TreeNode root){
        if(root == null)return;
        exploreTree(root.left);
        min = Math.min(min, Math.abs(prev - root.val));
        prev = root.val;
        exploreTree(root.right);
    }
}
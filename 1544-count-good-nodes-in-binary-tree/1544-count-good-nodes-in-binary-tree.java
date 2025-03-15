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
    int good = 0;
    public int goodNodes(TreeNode root) {
        //Maxdepth for each path at each node
        int maxDepSoFar = Integer.MIN_VALUE;
        search(root, maxDepSoFar);
        //Number of good nodes
        return good;
    }
    public void search(TreeNode root, int maxDepSoFar){
        if(root == null)return;
        if(root.val >= maxDepSoFar){
            good++;
            maxDepSoFar = root.val;
        }
        search(root.left, maxDepSoFar);
        search(root.right, maxDepSoFar);
    }
}
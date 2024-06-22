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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if(root.left ==null && root.right == null){
            if(targetSum == root.val)return true;
        }
        int sumSoFar=0;
        boolean ans = hasPathSumHelper(root, targetSum, sumSoFar);
        return ans;
    }
    public boolean hasPathSumHelper(TreeNode root, int target, int sumSoFar){
        if(root ==null)return false;
        sumSoFar+=root.val;
        if(root.left ==null && root.right == null){
            if(target == sumSoFar)return true;
        }
        return hasPathSumHelper(root.left, target, sumSoFar) || hasPathSumHelper(root.right, target, sumSoFar);
    }
}
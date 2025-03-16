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
    int maxPath = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        search(root.left, 1, false);
        search(root.right, 1, true);
        return maxPath;
    }
    void search(TreeNode node, int currPath, boolean dirRight){
        if(node == null) return;
        maxPath = Math.max(maxPath, currPath);
        if(dirRight){
            search(node.left, currPath+1, false);
            search(node.right, 1, true);  
        }
        else{
            search(node.right, currPath+1, true);
            search(node.left, 1, false);  
        }
    }

}
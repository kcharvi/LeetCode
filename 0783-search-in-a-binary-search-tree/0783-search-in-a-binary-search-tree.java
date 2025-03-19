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
    public TreeNode searchBST(TreeNode root, int val) {        
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        //     TreeNode curr = q.remove();
        //     int qsize = q.size();
        //     if(curr.val == val)
        //         return curr;
        //     if(curr.left!=null)q.add(curr.left);
        //     if(curr.right!=null)q.add(curr.right);
        // }
        // return null;

        // BINARY SEARCH TREE PROPERTY
        while(root != null && root.val != val){
            root = val < root.val ? root.left:root.right;
        }
       return root;

    }
}
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // approach: use preorder for the root and inorder to set boundaries of left and right.
        // Got the root while traversing preorder[] ... then until u get this root in inorder[] ... all those elements will be left of this root.
        // and all the elements after this root in the inorder[] are the right of this root.
        
        if(preorder.length == 0 || inorder.length == 0)return null;

        TreeNode root = new TreeNode(preorder[0]);
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                idx = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+idx), 
                              Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), 
                               Arrays.copyOfRange(inorder, idx+1, inorder.length));
        
        return root;

    }
}
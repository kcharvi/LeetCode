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
    int pre = 0;
    int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // approach: use preorder for the root and inorder to set boundaries of left and right.
        // Got the root while traversing preorder[] ... then until u get this root in inorder[] ... all those elements will be left of this root.
        // and all the elements after this root in the inorder[] are the right of this root.
        return create(preorder,inorder,Integer.MIN_VALUE);
    }
    public TreeNode create(int[] preorder, int[] inorder, int end){
        if(pre >= preorder.length){
            return null;
        }
        if(inorder[in] == end){
            in++;
            return null;
        }
        TreeNode root = new TreeNode (preorder[pre++]);
        root.left = create(preorder,inorder,root.val);
        root.right = create(preorder,inorder,end);
        return root;
    }
}
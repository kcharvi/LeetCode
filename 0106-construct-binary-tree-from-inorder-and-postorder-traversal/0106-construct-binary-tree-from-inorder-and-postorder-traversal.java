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
// class Solution {
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         if(postorder.length == 0 || inorder.length==0)return null;
//         int v=postorder[postorder.length-1];
//         TreeNode root = new TreeNode(v);
//         int idx=0;
//         for(int i =0; i<inorder.length; i++){
//             if(inorder[i]==v){
//                 idx = i;
//                 break;
//             }
//         }
        
//         root.left = buildTree(Arrays.copyOfRange(inorder, 0, idx),
//                               Arrays.copyOfRange(postorder, 0, idx));
//         root.right = buildTree(Arrays.copyOfRange(inorder, idx + 1, inorder.length),
//                                Arrays.copyOfRange(postorder, idx, postorder.length - 1));
        
//         return root;
//     }
    
// }

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int[] idx = new int[] { n - 1 };
        return construct2(inorder, postorder, 0, n - 1, idx);
    }

    private TreeNode construct2(int[] inorder, int[] postorder, int start, int end, int[] idx)  {
        if (start > end) {
            return null;
        }
        int rootVal = postorder[idx[0]];
        int i;
        for (i = end; i >= start; i--) {
            if (inorder[i] == rootVal) {
                break;
            }
        }
        idx[0]--;
        TreeNode root = new TreeNode(rootVal);
        root.right = construct2(inorder, postorder, i + 1, end, idx); 
        root.left = construct2(inorder, postorder, start, i - 1, idx); 
        return root;
    }
}
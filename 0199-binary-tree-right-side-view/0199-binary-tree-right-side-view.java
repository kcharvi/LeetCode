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
    ArrayList<Integer> list = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root, 0);
        return list;
    }
    public void rightSideViewHelper(TreeNode root, int depth){
        if(root == null)return;
        if(list.size() == depth)list.add(root.val);
        rightSideViewHelper(root.right, depth+ 1);
        rightSideViewHelper(root.left,depth+ 1);
        
    }
}
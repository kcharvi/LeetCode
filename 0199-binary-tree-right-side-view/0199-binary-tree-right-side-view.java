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
        search(root, 0);
        return list;
    }
    void search(TreeNode node, int depth){
        if(node==null)return;
        if(list.size() == depth)
            list.add(node.val);
        search(node.right, depth+1);
        search(node.left, depth+1);
    }
}
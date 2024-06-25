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
    List<Integer> list = new ArrayList();
    public int getMinimumDifference(TreeNode root) {
        exploreTree(root);
        Collections.sort(list);
        int min=Integer.MAX_VALUE;
        for(int i =1; i <list.size(); i++){
            min = Math.min(min,Math.abs(list.get(i-1)-list.get(i)));
        }
        return min;
    }
    public void exploreTree(TreeNode root){
        if(root == null)return;
        list.add(root.val);
        exploreTree(root.left);
        exploreTree(root.right);
    }
}
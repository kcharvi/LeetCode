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
    List<Integer> list1 = new ArrayList();
    List<Integer> list2 = new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //Collect leaves of root1
        collect(root1, list1);

        //Collect leaves of root2
        collect(root2, list2);

        //Compare and return
        if(list1.size() != list2.size())return false;
        for(int i=0; i<list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i)))
                return false;
        }
        return true;
    }
    public void collect(TreeNode root, List<Integer> list){
        if(root == null)return;
        if(root.left == null && root.right == null)
            list.add(root.val);
        collect(root.left, list);
        collect(root.right, list);
    }
}
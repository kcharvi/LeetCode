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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int dir=0;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> list = new ArrayList();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                if(node==null)continue;
                list.add(node.val);
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);               
            }
            if(dir%2==0){
                if(!list.isEmpty())ans.add(list);            
            }
            else{
                Collections.reverse(list);
                if(!list.isEmpty())ans.add(list); 
            }
            dir++;
        }
        return ans;
    }
}
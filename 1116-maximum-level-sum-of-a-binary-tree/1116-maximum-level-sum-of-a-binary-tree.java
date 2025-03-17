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

// SOLUTION 1:
// class Solution {
//     HashMap<Integer,ArrayList<Integer>> map = new HashMap(); 
//     public int maxLevelSum(TreeNode root) {
//         //bfs populate the map
//         populateBFS(root, 0);
//         int maxSum = Integer.MIN_VALUE;
//         int maxKey = 0;
//         for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
//             int sum = 0;
//             for(Integer i: entry.getValue()){
//                 sum+=i;
//             }
//             if(sum>maxSum){
//                 maxSum = sum;
//                 maxKey = entry.getKey();
//             }
//         }
//         return maxKey+1;
//     }
//     void populateBFS(TreeNode node, int depth){
//         if(node == null)return;
//         if(map.containsKey(depth)){
//             ArrayList<Integer> list = map.get(depth);
//             list.add(node.val);
//         }
//         else{
//             ArrayList<Integer> list = new ArrayList();
//             list.add(node.val);
//             map.put(depth, list);
//         }
//         populateBFS(node.left, depth+1);
//         populateBFS(node.right, depth+1);
//     }
// }

// SOLUTION 2:
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1;
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currsize = queue.size();
            int sum = 0;
            for(int i=0; i<currsize; i++){
                TreeNode node = queue.remove();
                sum+=node.val;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            if(sum>maxSum){
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
        
}
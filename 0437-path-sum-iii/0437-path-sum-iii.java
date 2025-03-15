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
//     int totalPaths = 0;
//     public int pathSum(TreeNode root, int targetSum) {
//         search(root, targetSum, 0);
//         return totalPaths;
//     }

//     public void search(TreeNode root, int targetSum, int sumSoFar){
//         if(root == null)return;
//         if(sumSoFar == targetSum)
//             totalPaths++;
        
//         search(root.left, targetSum, sumSoFar+root.val);
//         search(root.right, targetSum, sumSoFar+root.val);
//         search(root.left, targetSum, 0);
//         search(root.right, targetSum, 0);
//     }
// }

import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // Calculate paths including root, then move left and right
        return countPaths(root, targetSum) 
                + pathSum(root.left, targetSum) 
                + pathSum(root.right, targetSum);
    }

    private int countPaths(TreeNode node, long targetSum) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.val == targetSum) count++;
        
        // Recursively check left and right with the updated sum
        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);
        
        return count;
    }
}

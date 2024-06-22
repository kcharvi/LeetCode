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
    ArrayList<Integer> list;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        if(root.left == null && root.right ==null)return root.val;
        int numberDigitWithRoot = 0;
        list = new ArrayList();
        sumNumbersHelper(root, numberDigitWithRoot, list);
        int sum=0;
        for(Integer i: list)sum+=(int)i;
        return sum;
    }
    public void sumNumbersHelper(TreeNode root, int numberDigitWithRoot ,ArrayList<Integer> list){
        if(root == null)return;
        numberDigitWithRoot = numberDigitWithRoot*10 + root.val;
        if(root.left == null && root.right == null){
            list.add(numberDigitWithRoot);
        }
        sumNumbersHelper(root.left, numberDigitWithRoot, list);
        sumNumbersHelper(root.right, numberDigitWithRoot, list);
    }
}
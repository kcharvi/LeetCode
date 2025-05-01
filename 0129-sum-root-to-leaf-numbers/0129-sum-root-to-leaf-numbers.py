# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        total_sum = 0
        sums = []
        
        def dfs(root, number_formed):
            if not root:
                return
            
            new_number = number_formed * 10 + root.val
            if root.left is None and root.right is None:
                sums.append(new_number)
                
            dfs(root.left, new_number)
            dfs(root.right, new_number)
            

        dfs(root, 0)
        for i in sums:
            total_sum+=i
        return total_sum
        
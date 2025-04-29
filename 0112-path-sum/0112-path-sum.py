# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        def check(root, target) -> bool:
            if not root:
                return False 
            if not root.left and not root.right:
                return target == root.val
            target -= root.val
            return check(root.left, target) or check(root.right, target)
        return check(root, targetSum)
        
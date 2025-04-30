# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            dfs(root.right)
            temp = root.right
            root.right = root.left
            root.left = None
            end = root
            while end.right != None:
                end = end.right
            end.right = temp

        dfs(root)
        
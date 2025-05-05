# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # at any node maxLeft + maxRight
        # Keep diameter tracking max diameter
        # Optimize? find depth on left and depth on right
        # Then calculate with -1 of path down as you move level down
        diameter = 0

        def dfs(root) -> int:
            nonlocal diameter
            if root is None:
                return 0

            maxLeft = dfs(root.left)
            maxRight = dfs(root.right)
            diameter = max(diameter, maxLeft+maxRight)
            return max(maxLeft, maxRight)+1
        dfs(root)
        return diameter


        
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

        def dfs(root, level) -> int:
            nonlocal diameter
            if root is None:
                return 0

            maxLeft = dfs(root.left, level+1)
            maxRight = dfs(root.right, level+1)
            diameter = max(diameter, maxLeft+maxRight)
            return max(maxLeft, maxRight)+1
        dfs(root, 0)
        return diameter


        
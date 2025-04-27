# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        def getMinDepth(root) -> int:
            if root is None:
                return 0
            if root.left and root.right:
                return 1+min(getMinDepth(root.left), 
                         getMinDepth(root.right))
            elif root.left:
                return 1+ getMinDepth(root.left)
            else:
                return 1+ getMinDepth(root.right)
        return getMinDepth(root)
        
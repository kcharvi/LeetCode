# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def get_depth(node) -> int:
            if node is None:
                return 0
            return 1 + max(get_depth(node.left), 
                          get_depth(node.right))
        return get_depth(root)
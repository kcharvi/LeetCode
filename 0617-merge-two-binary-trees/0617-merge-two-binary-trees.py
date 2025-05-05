# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:

        def dfs(root1, root2) -> TreeNode:
            if root1 is None and root2 is None:
                return None
            
            val1 = root1.val if root1 else 0
            val2 = root2.val if root2 else 0

            merged = TreeNode(val1 + val2)

            merged.left = dfs(root1.left if root1 else None, root2.left if root2 else None)
            merged.right = dfs(root1.right if root1 else None, root2.right if root2 else None)
            return merged

        return dfs(root1, root2)
        
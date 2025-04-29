# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def height(root) -> int:
            if not root:
                return 0
            return 1+max(height(root.left), height(root.right))

        
        def depthOfCurrentRootChildren(root) -> bool:
            if not root:
                return True
            
            if abs(height(root.left) - height(root.right)) <= 1 and \
               depthOfCurrentRootChildren(root.left) and \
               depthOfCurrentRootChildren(root.right):
                return True
            else:
                return False

        return depthOfCurrentRootChildren(root)
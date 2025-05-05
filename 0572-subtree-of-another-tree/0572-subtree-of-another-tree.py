# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False
        def isSameTree(root, subRoot) -> bool:
            if not root and not subRoot:
                return True
            if not root or not subRoot:
                return False
            val = (root.val == subRoot.val)
            checkLeft = isSameTree(root.left, subRoot.left)
            checkRight = isSameTree(root.right, subRoot.right)
            return checkLeft and checkRight and val

        if isSameTree(root, subRoot):
            return True
        return self.isSubtree(root.left , subRoot) or self.isSubtree(root.right, subRoot)

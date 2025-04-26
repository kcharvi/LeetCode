# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        flag = True
        def inorder(p, q):
            nonlocal flag
            if p is None and q is None:
                return 
            if p is None or q is None:
                flag = False
                return
            if p.val != q.val:
                flag = False

            inorder(p.left, q.left)
            inorder(p.right, q.right)
        inorder(p, q)
        return flag
        
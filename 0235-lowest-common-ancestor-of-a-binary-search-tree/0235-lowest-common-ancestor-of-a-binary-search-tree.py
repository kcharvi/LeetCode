# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def searchLCA(root, p, q) -> 'TreeNode':
            if root.val == p.val or root.val == q.val:
                return root

            if root.val > p.val and root.val < q.val:
                return root
            
            if root.val > q.val:
                return searchLCA(root.left, p, q)
            
            else:
                return searchLCA(root.right, p, q)
            

        if p.val > q.val:
            p, q = q, p
        return searchLCA(root, p, q)
        
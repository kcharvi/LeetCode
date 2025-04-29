# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
    
        def check(root) -> (int, bool):
            if not root:
                return 0, True
            
            lh, leftBalance = check(root.left)
            rh, rightBalance = check(root.right)

            height = 1+max(lh, rh)
            isBalanced = (abs(lh - rh) <= 1) and leftBalance and rightBalance
            return height, isBalanced

        return check(root)[1]
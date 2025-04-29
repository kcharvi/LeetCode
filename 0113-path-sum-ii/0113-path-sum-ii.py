# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def searchPathSum(root, target, currlist):
            if not root:
                return 
            currlist.append(root.val)
            if not root.left and not root.right and target == root.val:
                result.append(currlist[:])
                
            else:    
                remaining = target - root.val
                searchPathSum(root.left, remaining, currlist)
                searchPathSum(root.right, remaining, currlist)
            
            currlist.pop()

        searchPathSum(root, targetSum, [])
        return result
        
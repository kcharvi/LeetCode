# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        max_sum = float('-inf')

        def pathSum(root) -> int:
            nonlocal max_sum

            if not root:
                return 0
            
            # calculate left path  taking only positive path sums
            leftPathSum = max(pathSum(root.left), 0)

            # calculate right path sum
            rightPathSum = max(pathSum(root.right), 0)


            # maximum = root is included in both sums OR
            #           root is included only in left sum
            #           root is not included and maxsum can be found in left subtree     
            #           root is included only in right sum
            #           root is not included and maxsum can be found in right subtree  
            
            max_sum = max(leftPathSum + rightPathSum + root.val, max_sum)
            return max(leftPathSum, rightPathSum) + root.val
            
        pathSum(root)   
        return max_sum
        
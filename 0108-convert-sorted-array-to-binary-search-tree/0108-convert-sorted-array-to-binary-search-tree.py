# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:

        def build(nums) -> TreeNode:
            l = 0
            r = len(nums)
            if l<r:
                mid = l+(r-l)//2
                root = TreeNode(nums[mid])
                root.left = build(nums[:mid])
                root.right = build(nums[mid+1:])
                return root
            else: return None
        
        return build(nums)
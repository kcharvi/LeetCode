# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        arr = []
        def inorder(root):
            if root is None:
                return
            inorder(root.left)
            arr.append(root)
            inorder(root.right)

        inorder(root)

        first = second = None

        for i in range(1, len(arr)):
            if arr[i].val < arr[i-1].val:
                if not first:
                    first = arr[i-1]
                    second = arr[i]
                else:
                    second = arr[i]
                    break

        first.val, second.val = second.val, first.val
                





        
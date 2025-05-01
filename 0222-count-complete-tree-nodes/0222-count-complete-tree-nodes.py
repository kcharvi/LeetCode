# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        count = 0
        q = deque([root])
        while q:
            lq = len(q)
            count+=lq
            for _ in range(lq):
                node = q.popleft()
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
        return count

        
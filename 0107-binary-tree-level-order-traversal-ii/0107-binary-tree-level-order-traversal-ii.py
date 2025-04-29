# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = deque([root])
        result = deque()
        while q:
            lq = len(q)
            curr_level = []
            for _ in range(lq):
                node = q.popleft()
                curr_level.append(node.val)
                if not node.left == None:
                    q.append(node.left)
                if not node.right == None:
                    q.append(node.right)
            result.appendleft(curr_level)
        
        return list(result)
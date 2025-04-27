# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        ans = []
        q = deque([root])
        dire = True
        while q:
            _no = len(q)
            _nodes = []
            for _ in range(_no):
                if dire:
                    node = q.popleft()
                else:
                    node = q.pop()
                _nodes.append(node.val)
                if dire:
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
                else:
                    if node.right:
                        q.appendleft(node.right)
                    if node.left:
                        q.appendleft(node.left)

            dire = not dire
            ans.append(_nodes)
        return ans 
        
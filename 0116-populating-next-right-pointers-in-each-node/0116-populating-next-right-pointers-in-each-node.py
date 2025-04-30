"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        q = deque([root])
        while q:
            lq = len(q)
            curr_level = []
            for _ in range(lq):
                node = q.popleft()
                curr_level.append(node)
                if not node.left == None:
                    q.append(node.left)
                if not node.right == None:
                    q.append(node.right)
            for i in range(0, len(curr_level)-1):
                curr_level[i].next = curr_level[i+1]
        return root   


                
        
        
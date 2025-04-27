"""
# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        # def getMaxDepth(node) -> int:
        #     if node is None:
        #         return 0
        #     maxi = 0
        #     children = node.children
        #     for child in children:
        #         maxi = max(maxi, getMaxDepth(child))
        #     return 1+maxi
        # return getMaxDepth(root)
        if not root:
            return 0

        queue = deque([(root, 1)])
        while queue:
            levels_so_far = len(queue)
            for _ in range(levels_so_far):
                current_node, level = queue.popleft()
                for child in current_node.children:
                    queue.append((child, level+1))
                
        return level
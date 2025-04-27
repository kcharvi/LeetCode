# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []

        queue = deque([root])
        result = deque()

        while queue:
            level_size = len(queue)

            nodes_in_current_level = []

            for _ in range(0, level_size):
                node = queue.popleft()
                nodes_in_current_level.append(node.val)

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
            
            result.appendleft(nodes_in_current_level)

        
        return list(result)
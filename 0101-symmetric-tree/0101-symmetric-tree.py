# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        q = deque()
        if root.left:
            q.append(root.left)
        if root.right:
            q.append(root.right)
        if len(q) == 1:
            return False
        while q:
            no_nodes = len(q)
            current_level_nodes = []
            for nodes in range(no_nodes):
                current_node = q.popleft()
                current_level_nodes.append(current_node.val if current_node else None)
                if current_node:
                    q.append(current_node.left if current_node.left else None)
                    q.append(current_node.right if current_node.right else None)
            
            if current_level_nodes != current_level_nodes[::-1]:
                return False

        return True
        
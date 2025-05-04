# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        ans = []

        def dfs(root, path):
            if root is None:
                return
        
            path += str(root.val)+"->"
            if root.left == None and root.right == None:
                ans.append(path[:-2])
                path = ""
            
            dfs(root.left, path)
            dfs(root.right, path)
         

        dfs(root, "")
        return ans
        
        
        
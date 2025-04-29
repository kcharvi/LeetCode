# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        def build(inorder, postorder) -> TreeNode:
            if not postorder or not inorder:
                return
            
            node_val = postorder.pop()
            node = TreeNode(node_val)
            node_index = inorder.index(node_val)

            node.right = build(inorder[node_index+1:], postorder)
            node.left = build(inorder[:node_index], postorder)
            

            return node         
        
        return build(inorder, postorder)

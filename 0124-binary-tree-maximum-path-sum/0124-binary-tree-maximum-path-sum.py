class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = float('-inf')

        def dfs(node):
            nonlocal max_sum
            if not node:
                return 0

            # compute max gain from left and right subtrees
            left = max(dfs(node.left), 0)   # ignore negative paths
            right = max(dfs(node.right), 0)

            # path that passes through current node
            current_max = node.val + left + right
            max_sum = max(max_sum, current_max)

            # return max gain if path continues through parent
            return node.val + max(left, right)

        dfs(root)
        return max_sum

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        minheap = []
        q = deque([root])
        while q:
            lq = len(q)
            for _ in range(lq):
                node = q.popleft()
                heapq.heappush(minheap, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        for _ in range(k-1):
            heapq.heappop(minheap)
        return heapq.heappop(minheap)

        
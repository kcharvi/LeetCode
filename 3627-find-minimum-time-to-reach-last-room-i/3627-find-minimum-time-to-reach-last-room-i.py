class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        visited = [[False for _ in range(m)] for _ in range(n)]
        heap = [(0, 0, 0)]

        while heap:
            curr_time, i, j = heappop(heap)
            if visited[i][j]:
                continue
            visited[i][j] = True

            if (i, j) == (n-1, m-1):
                return curr_time
            
            for dx, dy in dirs:
                idx, idy = i+dx, j+dy

                if 0 <= idx < n and 0 <= idy < m and  not visited[idx][idy]:
                    next_time = max(curr_time, moveTime[idx][idy])
                    heappush(heap, (next_time+1, idx, idy))

        # # first column
        # for i in range(1, n):
        #     wait = max((moveTime[i][0] - dp[i-1][0]), 0)
        #     dp[i][0] = 1 + wait + dp[i-1][0]

        # # first row
        # for i in range(1, m):
        #     wait = max((moveTime[0][i] - dp[0][i-1]), 0)
        #     dp[0][i] = 1 + wait + dp[0][i-1]
        
        # for i in range(1, n):
        #     for j in range(1, m):
        #         from_top = 1 + dp[i-1][j] + max((moveTime[i][j] - dp[i-1][j]), 0)
        #         from_left = 1 + dp[i][j-1] + max((moveTime[i][j] - dp[i][j-1]), 0)
        #         dp[i][j] = min(from_top, from_left)
        
        return -1
        
class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        visited = [[False for _ in range(n)] for _ in range(m)]
        heap = [(0, 0, 0)]

        while heap:
            time, i, j = heapq.heappop(heap)
            if visited[i][j]:
                continue
            visited[i][j] = True

            if (i, j) == (m-1, n-1):
                return time
            
            for dir in dirs:
                idx = i+dir[0]
                jdy = j+dir[1]

                if 0<=idx<m and 0<=jdy<n and not visited[idx][jdy]:
                    arrive = time + 1
                    required = grid[idx][jdy]
                    if arrive < required:
                        diff = required - arrive
                        if diff % 2 == 1:
                            arrive = required + 1
                        else:
                            arrive = required
                    heapq.heappush(heap, (arrive, idx, jdy))
        return -1

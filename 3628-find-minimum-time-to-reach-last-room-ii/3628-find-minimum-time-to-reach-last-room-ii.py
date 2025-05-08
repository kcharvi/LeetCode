class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]

        # Dijkstra's Algorith with min Heap
        # Visited 
        visited = [[False for _ in range(m)] for _ in range(n)]

        # heap to store minimum time for the next step (moveTime, i, j)
        cost = True   # True: cost = 1  --  False: cost = 2
        heap = [(0, 0, 0, cost)]
        visited[0][0] = True
        while heap:
            curr_time, i, j, cost = heapq.heappop(heap)

            if (i, j) == (n-1, m-1):
                return curr_time

            for dir in dirs:
                idx = i+dir[0]
                idy = j+dir[1]

                if 0<=idx<n and 0<=idy<m and not visited[idx][idy]:
                    move_cost = 1 if cost else 2
                    wait = (moveTime[idx][idy] - curr_time)
                    wait = max(wait, 0)
                    heapq.heappush(heap, (curr_time+wait+move_cost, idx, idy, not cost))
                    visited[idx][idy] = True

        return -1



        
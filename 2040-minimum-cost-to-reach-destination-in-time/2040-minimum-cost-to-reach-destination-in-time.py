class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], passingFees: List[int]) -> int:
        cities = len(passingFees)
        
        graph = defaultdict(list)
        for u, v, time in edges:
            graph[u].append((v, time))
            graph[v].append((u, time))

        # visited[city][time] = minimum cost to reach city with that time
        visited = [[float('inf')] * (maxTime+1) for _ in range(cities)]

        heap = [(passingFees[0], 0, 0)]

        while heap:
            totalCost, totalTime, u = heapq.heappop(heap)

            if u == cities-1:
                return totalCost

            for v, t in graph[u]:
                cost = totalCost + passingFees[v]
                time = totalTime + t
                if time <= maxTime and visited[v][time] > cost:
                    heapq.heappush(heap, (cost, time, v))              
                    visited[v][time] = cost
        return -1        
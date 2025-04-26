class Solution:
    def numTrees(self, n: int) -> int:
        memory = {}
        
        def helper(start, end) -> int:
            count = 0
            if start>end:
                return 1
            if (start, end) in memory:
                return memory[(start,end)]
            
            for i in range(start, end+1):
                l = helper(start, i-1)
                r = helper(i+1, end)
                count += l*r
            
            memory[start, end] = count
            return count

        return helper(1, n)
        
        
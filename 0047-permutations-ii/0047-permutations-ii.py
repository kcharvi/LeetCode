class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        perm = []
        countMap = {n:0 for n in nums}

        # Populate the counts in hashmap
        for n in nums:
            countMap[n]+=1

        def dfs():
            if len(perm) == len(nums):
                res.append(perm.copy())
                return
            
            for n in countMap:
                if countMap[n] > 0:
                    perm.append(n)
                    countMap[n] -= 1

                    dfs()

                    perm.pop()
                    countMap[n] += 1

        
        dfs()
        return res
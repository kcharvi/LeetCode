class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        sum1 = 0
        zro1 = 0
        for i in nums1:
            sum1+=i
            zro1 += 1 if i == 0 else 0
        sum2 = 0
        zro2 = 0
        for i in nums2:
            sum2+=i
            zro2 += 1 if i == 0 else 0

        minsum1 = sum1 + zro1
        minsum2 = sum2 + zro2

        if minsum1 == minsum2:
            return minsum1

        if (minsum1 > minsum2 and zro2 == 0) or (minsum1 < minsum2 and zro1 == 0):
            return -1
        
        else:
            return max(minsum1, minsum2)
            


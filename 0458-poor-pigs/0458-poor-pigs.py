class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:

        # maximum might be 1000 pigs
        # minutesToDie / minutesToTest + 1 ~= number of tests T
        # with p pigs and T tests, total buckets that can be tested is (T)^p
        # let p=2 and T=3, total buckets that can be tested is 3^2 = 9
        # Why (T)^p -> 
        # Test1 -> [(b1, b2, b3) fed to p1] and [(b3, b4, b5) fed to p2]
        #          i) Both die -> b3   -> END OF STORY
        #         ii) One Dies -> either (b1, b2) or (b4, b5)
        #               Test 2 -> let p1 survive Test 1 then: (b4 is fed to p1) -> Die? -> END OF STORY
        #                                                                          Not Dead? -> b5 is poisonous
        #        iii) None die -> poisonous is in (b6, b7, b8, b9)
        #               Test 2 -> [(b6, b7) fed to p1] and [(b8, b9) fed to p2]
        #                      i) One will die 
        #                    Test 3 -> let p1 survived then: (b8 is fed to p1) -> Die? -> END OF STORY
        #                                                                         Not Dead? -> b9 is poisonous
        if buckets == 1:
            return 0
        T = minutesToTest//minutesToDie + 1
        pigs = 0
        # while (T**pigs) < buckets:
        #     pigs += 1
        l = 0
        r = buckets
        while l<=r:
            pigs = l+(r-l)//2
            if (T**pigs) < buckets:
                l=pigs+1
            else: r = pigs-1
        return l



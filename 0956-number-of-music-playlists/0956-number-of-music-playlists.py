class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        
        MOD = 10**9 + 7
        
        # dp[i][j] = number of playlists of length i with j unique songs used

        dp = [[0] * (n + 1) for _ in range(goal+1)]  # n songs of goal length

        dp[0][0] = 1 #  n>0 so 1 song for goal length = 1

        for i in range(1, goal+1):
            for j in range(1, n+1):
                # ADD NEW SONG
                dp[i][j] += ( dp[i-1][j-1] * (n-(j-1)) )
                dp[i][j]%=MOD

                # REUSE AN OLD SONG
                if j>k:
                    dp[i][j] += ( dp[i-1][j] * (j-k) )
                    dp[i][j]%=MOD


        return dp[goal][n]
        
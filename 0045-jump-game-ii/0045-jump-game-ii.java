class Solution {
    public int jump(int[] nums) {
    
    // GREEDY - POINTERS SOLUTION 
    // Greedy is perfect here because:
    // It turns out the minimum number of jumps always occurs when you 
    // take the farthest next step at the right time.
    // I can go anywhere between i and end. Let me explore all those 
    // options and pick the farthest I can reach from here. Once I reach 
    // the end of my current range, I jump to the next range.   
        if(nums.length==1)return 0;
        int jumps = 0;
        int end = 0;
        int farthest = 0;
        //        i =       0       ,     1      ,     2      ,   
        // farthest = 0, max(2,0)=2 , max(4,2)=4 , max(3,4)=4 ,
        // jumps    = 0,    1       ,     1      ,     2      ,
        // end      = 0,    2       ,     2      ,     4      ,
        for(int i=0; i<nums.length-1; i++){
            farthest = Math.max(i+nums[i], farthest);
            if(i == end){
                jumps++;
                end = farthest;
            }
        }
        return jumps;


    // DP SOLUTION
    // Explore all ways to reach a position
    // At each step i, you ask:
    // "Who can reach me, and among those, who can get to me with the fewest jumps?"
        // if(nums.length==1)return 0;
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0] = 0;
        // // dp = [0, 1, 1, 2, 2] -> dp[i] 
        // for(int i=1; i<nums.length; i++){
        //     for(int j=0; j<i; j++){
        //         if(j+nums[j] >= i && dp[j] != Integer.MAX_VALUE) //if the current position i is reachable from j and j itself has been reachable
        //             dp[i] = Math.min(dp[j]+1, dp[i]); // minimum steps to reach i from j
        //     }   
        // }
        // return dp[nums.length-1];

    }
}
class Solution {
    // IDEA: SUM[(Waterlevel-heightofblock)*width]
    // Base Case: #ofBlocks should be more than 2
    // Need to take min(maxL, maxR)
    // Keep Track of the maximum boundary so far on the left and right end

    public int trap(int[] height) {
        if(height.length<=2)return 0;
        int n = height.length;
        int ans = 0;
        int l = 0;
        int r = n-1;
        int maxL = height[0];
        int maxR = height[n-1];
        while(l<r){
            if(maxL<maxR){
                l++;
                maxL = Math.max(height[l], maxL);
                ans+= maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(height[r], maxR);
                ans+=maxR - height[r];
            }
        }
        return ans;
    }
}
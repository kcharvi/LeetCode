class Solution {
    // IDEA: SUM[(Waterlevel-heightofblock)*width]
    // Base Case: #ofBlocks should be more than 2
    // Need to take min(maxL, maxR)
    // Keep Track of the maximum boundary so far on the left and right end

    public int trap(int[] height) {
        int res = 0;
        int l_max = height[0], r_max = height[height.length -1];
        int l = 0,r = height.length-1;
        while(l<r){
            if(l_max < r_max){
                //  
                if(height[l] > l_max ){
                    l_max = height[l];
                }
                else{
                    res += l_max-height[l];
                    l++;
                }
            }
            else{
                //maxLeft is more: then update the maxRight either height at or maxRight
                if(height[r] > r_max){
                    r_max = height[r];
                }

                // both same and equal case
                else{
                    res +=r_max - height[r];
                    r--;
                }
            }
        }
        return res;
    }
}
class Solution {
    public int maxArea(int[] height) {
        int max_area_till_now = Integer.MIN_VALUE;
        int l=0, r=height.length-1;
        int area = 0;
        while(l<r){
            area = Math.min(height[l], height[r])*(r - l);
            if(area > max_area_till_now){
                max_area_till_now = area;
            }
            if(height[l] < height[r] )l++;
            else r--;
        }
        return max_area_till_now;
    }
}
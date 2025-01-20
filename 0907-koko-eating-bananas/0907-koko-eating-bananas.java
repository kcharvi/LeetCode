class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length-1];
        while(left<right){
            int mid = left+(right - left)/2;
            if(eatTime(mid, piles) > h){
                left = mid+1;
            }
            else right = mid;
        }
        return left;
    }
    int eatTime(int rate, int[] piles){
        int time = 0;
        for(int i = 0; i<piles.length; i++){
            time += (piles[i]+rate-1)/rate;
        }
        return time;
    }
}
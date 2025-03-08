class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;
        for(int i : gain){
            altitude+=i;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
}
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        int[][] starts = new int[n][2];
        for(int i = 0; i<n; i++){
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        
        Arrays.sort(starts, Comparator.comparingInt(row -> row[0]));

        for(int i=0; i<n; i++){
            int target = intervals[i][1];
            int l = 0;
            int r = n-1;
            int index = -1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(starts[mid][0] >= target){
                    index = starts[mid][1];
                    r = mid-1;
                }
                else 
                    l = mid+1;
            }
            ans[i] = index;
        }
        return ans;
    }
}
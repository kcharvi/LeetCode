class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList();

        for(int i=0; i<intervals.length; i++){
            if(intervals[i][1]<newInterval[0]){
                ansList.add(intervals[i]);
            }
            else if(newInterval[1] < intervals[i][0]){
                ansList.add(newInterval);
                newInterval = intervals[i];
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        ansList.add(newInterval);
        int[][] ans = new int[ansList.size()][2];
        int i=0;
        for(int[] arr : ansList){
            ans[i++] = arr;
        }
        return ans;
    }   
}
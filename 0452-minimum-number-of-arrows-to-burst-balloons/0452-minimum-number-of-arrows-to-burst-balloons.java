class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)return 0;

        Arrays.sort(points, (a,b) -> {
            if(a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });


        int cnt=0;
        int last=points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0]<=last){
                last = Math.min(points[i][1], last);
            }
            else{
                last = points[i][1];
                cnt++;
            }
        }
        return cnt+1;

    }
}
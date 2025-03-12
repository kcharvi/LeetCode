class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int count =0;
        HashMap<ArrayList<Integer>, Integer> map = new HashMap();
        for(int i=0; i<n; i++){
            ArrayList<Integer> arr = new ArrayList();
            for(int j=0; j<n; j++){
                arr.add(grid[i][j]);
            }
            if(map.containsKey(arr))
                map.put(arr, map.get(arr)+1);
            else 
                map.put(arr, 1);

        }
        for(int j=0; j<n; j++){
            ArrayList<Integer> currcol = new ArrayList();
            for(int i=0; i<n; i++){
                currcol.add(grid[i][j]);
            }
            if(map.containsKey(currcol))
                count+=map.get(currcol);
        }
        return count;
    }
}
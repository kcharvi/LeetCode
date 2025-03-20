class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] connection: connections){
            int start = connection[0];
            int end = connection[1];
            graph.get(start).add(new int[]{end, 1});  //forward
            graph.get(end).add(new int[]{start, 0});  //backward
        }
        boolean[] enroute = new boolean[n];
        return dfs(0, enroute, graph);
    }
    int dfs(int currCity, boolean[] enroute, List<List<int[]>> graph){
        enroute[currCity]=true;
        int counter = 0;
        for(int[] neighbor: graph.get(currCity)){
            int nextCity = neighbor[0];
            int direction = neighbor[1];
            if(!enroute[nextCity]){
                counter+=direction;
                counter+=dfs(nextCity, enroute, graph);
            }
        }
        return counter;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!dfs(color, i, 0, graph))
                    return false;
            } 
        }
        return true;

    }
    boolean dfs(int[] color, int node, int col, int[][] graph){
        color[node] = col;
         for(int neighbor: graph[node]){
            if (color[neighbor] == -1) {
                if (!dfs(color, neighbor, 1 - col, graph))
                    return false;
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
        
    }
}
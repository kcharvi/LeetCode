class Solution {
    public boolean isBipartite(int[][] graph) {
    
    //BFS SOLUTION
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!bfs(graph, color, i))
                return false;
            }
        }
        return true;
    }

    boolean bfs(int[][] graph, int[] color, int node){
        Queue<Integer> queue = new LinkedList();
        queue.add(node);
        color[node] = 0;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int neighbor: graph[currentNode]){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[currentNode];
                    queue.add(neighbor);
                }
                else if(color[currentNode] == color[neighbor]){
                    return false;
                }
            }
        }
        return true;

    }


    

    // DFS SOLUTION
    //     int[] color = new int[graph.length];
    //     Arrays.fill(color, -1);
    //     for(int i=0; i<graph.length; i++){
    //         if(color[i] == -1){
    //             if(!dfs(color, i, 0, graph))
    //                 return false;
    //         } 
    //     }
    //     return true;

    // }
    // boolean dfs(int[] color, int node, int col, int[][] graph){
    //     color[node] = col;
    //      for(int neighbor: graph[node]){
    //         if (color[neighbor] == -1) {
    //             if (!dfs(color, neighbor, 1 - col, graph))
    //                 return false;
    //         } else if (color[neighbor] == col) {
    //             return false;
    //         }
    //     }
    //     return true;
        
    // }
}
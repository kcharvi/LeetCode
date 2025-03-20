class Solution {
    public int findCircleNum(int[][] isConnected) {
        int number_of_cities = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[number_of_cities];

        for(int i=0; i<number_of_cities; i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int curr_city = queue.poll();
            for(int i=0; i<isConnected.length; i++){
                if(isConnected[curr_city][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
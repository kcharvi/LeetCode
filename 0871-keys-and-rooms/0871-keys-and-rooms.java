class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<rooms.get(0).size(); i++)
            queue.add(rooms.get(0).get(i));
        boolean[] visited = new boolean[n];
        visited[0]=true;
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(!visited[curr]){
                for(int i=0; i<rooms.get(curr).size(); i++)
                    queue.add(rooms.get(curr).get(i));
                visited[curr] = true;
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
}
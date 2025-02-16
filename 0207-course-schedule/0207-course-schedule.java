// DFS Solution
// class Solution {
//     HashMap<Integer, ArrayList<Integer>> map = new HashMap();
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         for(int i=0; i<prerequisites.length; i++){
//             int course = prerequisites[i][0];
//             Integer prereq_ = prerequisites[i][1];
//             if (!map.containsKey(course)) {
//                 ArrayList<Integer> list = new ArrayList<>();
//                 list.add(prereq_);
//                 map.put(course, list);
//             }
//             else{
//                 map.get(course).add(prereq_);
//             }            
//         }
//         boolean[] visitedAllCourses = new boolean[numCourses];
//         boolean[] visitedCurrentCourseNeighbors = new boolean[numCourses];

//         for(int course = 0; course<numCourses; course++){
//             if(visitedAllCourses[course] == false && 
//                dfs(course, visitedAllCourses, visitedCurrentCourseNeighbors) == false) 
//                 return false;
//         }
//         return true;
//     }
//     boolean dfs(int course, boolean[] visitedAllCourses, boolean[] visitedCurrentCourseNeighbors){
//         if(visitedCurrentCourseNeighbors[course])
//             return false;
//         if(visitedAllCourses[course])
//             return true;

//         visitedCurrentCourseNeighbors[course] = true;
//         if(map.containsKey(course))
//         for(Integer prereq_ : map.get(course)){
//             if(dfs(prereq_, visitedAllCourses, visitedCurrentCourseNeighbors) == false) 
//                 return false;
//         }
//         visitedAllCourses[course] = true;
//         visitedCurrentCourseNeighbors[course] = false;
//         return true;
//     }

// }


// BFS Solution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adj List
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Indegree
        int[] inDegree = new int[numCourses];
        for(int[] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        //Queue Initialization with inDegree ==0
        Queue<Integer> que = new LinkedList();
        for(int i=0; i<numCourses; i++)
            if(inDegree[i] == 0)
                que.add(i);

        //BFS by counting the courses that can be taken
        int count = 0;
        while(!que.isEmpty()){
            int currentCourse = que.poll();
            count++;

            for(int neighbor : adj.get(currentCourse)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0)
                    que.add(neighbor);
            }

        }

        //If count in queue same as courses returns true
        return count == numCourses;
    }

}
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         Map<Integer, List<Integer>> courses = new HashMap();
//         // int[] indegree = new int[numCourses];
//         for(int[] prereq: prerequisites){
//             int a = prereq[0];
//             int b = prereq[1];
//             if(!courses.containsKey(a))
//                 courses.put(a, new ArrayList<>(b));
//             else courses.put(a, courses.get(a).add(b));
//             // indegree[a]++;
//         }

//         boolean visited[] = new boolean[numCourses];
//         for(int i =0; i<numCourses; i++){
//             if(visited[i] == false){
//                 boolean possible = dfs(courses, visited);
//             }
//         }
        
//         // Queue<Integer> q = new LinkedList();
//         // int count =0;
//         // while(!q.isEmpty()){
//         //     Map<Integer, List<Integer>> curr = q.poll();
//         //     Integer currCourse = curr.getKey();
//         //     List<Integer> currPrereqs = curr.getValue();
//         //     for(int i = 0; i < currPrereqs.size(); i++){
//         //         if(visited.contains(currPrereqs.get(i)))return false;
//         //         visited.add(currPrereqs.get(i));
//         //         q.add()
//         //     }
//         // }
//     }
//     public boolean dfs(Map<Integer, List<Integer>> courses, boolean[] visited){
//         if(courses)
//     }
// }

// class Node{
//     int course;
//     List<Integer> prereq;
//     Node(int val, prereq_){
//         int course = val;
//         prereq = new ArrayList(prereq_);
//     }
// }
import java.util.*;

class Solution {
    // Graph: course -> list of prerequisites
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            map.computeIfAbsent(course, k -> new ArrayList<>()).add(prereq);
        }
        
        // Arrays for tracking DFS:
        // 'visiting' for nodes in the current DFS recursion stack.
        // 'visited' for nodes that have been fully processed.
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        // Perform DFS for each course.
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course] && !dfs(course, visiting, visited)) {
                return false;
            }
        }
        return true;
    }
    
    // DFS to detect cycles.
    private boolean dfs(int course, boolean[] visiting, boolean[] visited) {
        // If this node is in the current recursion stack, we found a cycle.
        if (visiting[course]) {
            return false;
        }
        // If it's already fully processed, no need to explore it again.
        if (visited[course]) {
            return true;
        }
        
        // Mark this course as being visited in the current path.
        visiting[course] = true;
        
        // Explore all prerequisites (neighbors).
        if (map.containsKey(course)) {
            for (int prereq : map.get(course)) {
                if (!dfs(prereq, visiting, visited)) {
                    return false;
                }
            }
        }
        
        // Backtrack: mark the course as fully processed and remove it from the current path.
        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}

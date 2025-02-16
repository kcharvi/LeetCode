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

class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            Integer prereq_ = prerequisites[i][1];
            if (!map.containsKey(course)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prereq_);
                map.put(course, list);
            }
            else{
                map.get(course).add(prereq_);
            }            
        }
        boolean[] visitedAllCourses = new boolean[numCourses];
        boolean[] visitedCurrentCourseNeighbors = new boolean[numCourses];

        for(int course = 0; course<numCourses; course++){
            if(visitedAllCourses[course] == false && 
               dfs(course, visitedAllCourses, visitedCurrentCourseNeighbors) == false) 
                return false;
        }
        return true;
    }
    boolean dfs(int course, boolean[] visitedAllCourses, boolean[] visitedCurrentCourseNeighbors){
        if(visitedCurrentCourseNeighbors[course])
            return false;
        if(visitedAllCourses[course])
            return true;

        visitedCurrentCourseNeighbors[course] = true;
        if(map.containsKey(course))
        for(Integer prereq_ : map.get(course)){
            if(dfs(prereq_, visitedAllCourses, visitedCurrentCourseNeighbors) == false) 
                return false;
        }
        visitedAllCourses[course] = true;
        visitedCurrentCourseNeighbors[course] = false;
        return true;
    }

}
package HomeWork.Graph_3;
import java.util.*;

// Find out the indegree first, the course with indegree 0 will be studied first.

// T.C: O(2*(numCourser + prerequisites.length))
// S.C: O(prerequisites.length) + O(numCourses)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int nei: adj.get(curr)){
                indegree[nei]--;

                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        for(int i: indegree){
            if(i!=0){
                return false;
            } 
        }

        return true;
    }
}
public class course_schedule {
    
}

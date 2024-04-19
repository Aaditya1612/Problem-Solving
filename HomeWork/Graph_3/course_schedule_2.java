package HomeWork.Graph_3;
import java.util.*;

// Similar to course schedule 1, here we just need to add the node into a resultant array in every iteration of BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] res = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            res[k++] = curr;

            for(int i: adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        return k == numCourses ? res : new int[]{};
    }
}

public class course_schedule_2 {
    
}

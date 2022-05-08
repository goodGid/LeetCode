import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int prev = prerequisites[i][1];
            int next = prerequisites[i][0];
            adjacencyList.get(prev).add(next);
            inDegree[next]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        int[] ans = new int[numCourses];

        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            ans[idx] = top;
            idx++;

            for (int i : adjacencyList.get(top)) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        if (idx != numCourses) {
            return new int[] {};
        }
        return ans;
    }
}
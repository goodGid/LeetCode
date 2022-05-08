class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int size = prerequisites.length;
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            arr[prerequisites[i][0]]++;
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int top = q.poll();
            ans[idx++] = top;

            for (int i : list.get(top)) {
                arr[i]--;
                if (arr[i] == 0) {
                    q.add(i);
                }
            }
        }

        if (idx != numCourses) {
            return new int[] {};
        }

        return ans;
    }
}
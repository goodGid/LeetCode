class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {

        List<Set<Integer>> fromToList = new ArrayList<>();
        List<Set<Integer>> toFromList = new ArrayList<>();

        int size = g.length;

        for (int i = 0; i < size; i++) {
            fromToList.add(new HashSet<>());
            toFromList.add(new HashSet<>());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (g[i].length == 0) {
                q.add(i);
            }
            for (int j = 0; j < g[i].length; j++) {
                fromToList.get(i).add(g[i][j]);
                toFromList.get(g[i][j]).add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int idx = q.poll();
            ans.add(idx);

            for (int i : toFromList.get(idx)) {
                fromToList.get(i).remove(idx);
                if (fromToList.get(i).isEmpty()) {
                    q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
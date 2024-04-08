class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> st = new Stack<>();

        for (int[] item : intervals) {
            if (st.isEmpty()) {
                st.add(item);
            } else {
                int[] pop = st.pop();
                if (pop[1] >= item[0]) {
                    st.add(new int[] { pop[0], Math.max(pop[1], item[1]) });
                } else {
                    st.add(pop);
                    st.add(item);
                }
            }
        }

        int size = st.size();
        int[][] ans = new int[size][2];

        for (int i = size - 1; i >= 0; i--) {
            int[] pop = st.pop();
            ans[i][0] = pop[0];
            ans[i][1] = pop[1];
        }
        return ans;
    }
}
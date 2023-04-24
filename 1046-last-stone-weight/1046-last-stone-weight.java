class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : stones) {
            pq.add(i);
        }

        while (pq.size() > 1) {
            int v1 = pq.poll();
            int v2 = pq.poll();

            if (v1 == v2) {
                continue;
            } else {
                pq.add(v1 - v2);
            }
        }
        if (pq.isEmpty()) {
            return 0;
        } else {
            return Integer.valueOf(pq.poll());
        }
    }
}
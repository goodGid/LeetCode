class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;

        int l = 0;
        int r = costs.length - 1;

        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            q1.add(costs[i]);
            l++;
        }

        for (int i = 0; i < candidates; i++) {
            if (r >= l) {
                q2.add(costs[costs.length - 1 - i]);
            }
            r--;
        }

        while (k > 0) {
            if (q1.isEmpty() || q2.isEmpty()) {
                break;
            }

            if (q1.peek() < q2.peek()) {
                ans += q1.poll();
                if (l <= r) {
                    q1.add(costs[l]);
                    l++;
                }
            } else if (q1.peek() == q2.peek()) {
                ans += q1.poll();
                if (l <= r) {
                    q1.add(costs[l]);
                    l++;
                }
            } else {
                ans += q2.poll();
                if (l <= r) {
                    q2.add(costs[r]);
                    r--;
                }
            }
            k--;
        }

        while (k > 0) {
            k--;
            if (q1.isEmpty()) {
                ans += q2.poll();
            } else {
                ans += q1.poll();
            }
        }

        return ans;
    }
}
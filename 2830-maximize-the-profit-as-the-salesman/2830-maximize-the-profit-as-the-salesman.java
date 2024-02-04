class Solution {
    int m;
    int[] dp;

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(0) - b.get(0));
        Collections.sort(offers, Comparator.comparing(a -> a.get(0)));

        m = offers.size();
        dp = new int[m];
        Arrays.fill(dp, -1);
        dfs(0, offers);
        return dp[0];
    }

    private int dfs(int idx, List<List<Integer>> offers) {
        if (idx == m) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Pick X
        int sum1 = dfs(idx + 1, offers);

        // Pick O
        int nextIdx = findNextIdx(idx + 1, offers.get(idx).get(1), offers);
        int sum2 = offers.get(idx).get(2);
        if (nextIdx != -1) {
            sum2 += dfs(nextIdx, offers);
        }

        dp[idx] = Math.max(sum1, sum2);

        return dp[idx];
    }

    private int findNextIdx(int left, int target, List<List<Integer>> offers) {
        int l = left;
        int r = m - 1;
        int nextIdx = -1;
        while (l <= r) {
            int mid = r - (r - l) / 2;
            int mv = offers.get(mid).get(0);
            if (mv > target) {
                nextIdx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nextIdx;
    }
}
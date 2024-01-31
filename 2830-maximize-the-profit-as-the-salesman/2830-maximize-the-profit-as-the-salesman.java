// 240131
// 내가 풀었던 코드 : https://leetcode.com/submissions/detail/1162060200
// 전체적인 로직은 동일하다.
// 다만 현재 idx를 take 하였을 경우 다음에 접근 하는 idx를 찾는 로직에서
// 나는 for문으로 찾았고 정답 코드는 BinarySearch로 찾았다.
// from : https://leetcode.com/problems/maximize-the-profit-as-the-salesman/discuss/3935104/Clean-Code-with-Explanation

class Solution {
    int[] memo;
    int m;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b)-> a.get(0)-b.get(0));
        this.m = offers.size();
        memo = new int[m];
        Arrays.fill(memo, -1);
        return dfs(0, offers);
    }

    int dfs(int i, List<List<Integer>> offers) {
        if(i == m) {
            return 0;
        }
        if(memo[i] != -1) {
            return memo[i];
        }
        // not sell / don't take the offer
        int notSellProfit = dfs(i+1, offers);
        // sell / take the offer
        int nextPossibleIdx = binSearch(i+1, offers.get(i).get(1), offers);
        int sellProfit = offers.get(i).get(2);
        if(nextPossibleIdx != -1) {
            sellProfit += dfs(nextPossibleIdx, offers);
        }
        return memo[i] = Math.max(sellProfit, notSellProfit);
    }

    // Looks for next possible offer starting from left = idx+1 till right = m-1;
    int binSearch(int left, int end, List<List<Integer>> offers) {
        int right = m-1;
        int i=-1;
        while(left <= right) {
            int mid = right - (right-left)/2;
            int start = offers.get(mid).get(0);
            if(start > end) {
                i = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return i;
    }
}

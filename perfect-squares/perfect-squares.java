class Solution {
    int ans = 10000;

    public int numSquares(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                list.add(i);
            }
        }

        go(n, list, new ArrayList<>(), 0);

        return ans;
    }

    // sl = square list
    // al = answer list
    private void go(int n, List<Integer> sl, List<Integer> al, int idx) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            ans = Math.min(ans, al.size());
            return;
        }

        if (ans <= al.size()) {
            return;
        }

        for (int i = idx; i < sl.size(); i++) {
            al.add(sl.get(i));
            go(n - sl.get(i), sl, al, i);
            al.remove(al.size() - 1);
        }
    }
}
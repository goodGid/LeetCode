class Solution {

    int left_cnt;
    int right_cnt;
    List<String> ansList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        List<String> ansCandidate = new ArrayList<>();
        solve(ansCandidate, n);
        return ansList;
    }

    private void solve(List<String> ansCandidate, int n) {
        if (ansCandidate.size() == n * 2) {

            StringBuilder sb = new StringBuilder();
            for (String s : ansCandidate) {
                sb.append(s);
            }
            ansList.add(sb.toString());
            return;
        }

        if (left_cnt < n) {
            ansCandidate.add("(");
            left_cnt++;
            solve(ansCandidate, n);
            ansCandidate.remove(ansCandidate.size() - 1);
            left_cnt--;
        }

        if (left_cnt >= right_cnt + 1) {
            ansCandidate.add(")");
            right_cnt++;
            solve(ansCandidate, n);
            ansCandidate.remove(ansCandidate.size() - 1);
            right_cnt--;
        }
    }
}

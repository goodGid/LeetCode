class Solution {

    List<String> ansList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder(), n, 0, 0);
        return ansList;
    }

    private void solve(StringBuilder sb, int n, int open, int close) {
        if (sb.length() == n * 2) {
            ansList.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            solve(sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > close) {
            sb.append(")");
            solve(sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

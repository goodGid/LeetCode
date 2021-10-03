class Solution {
    private String left = "(";
    private String right = ")";
    List<String> answer = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        go(n, new ArrayList<>(), 0, 0);
        return answer;
    }
    
    private void go(int n, List<String> ans, int lc, int rc) {
        if (ans.size() == n*2) {
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<ans.size(); i++) {
                sb.append(ans.get(i));
            }
            answer.add(sb.toString());
            return ;
        }
        
        if (lc < rc) {
            return ;
        }
        
        if (lc < n) {
            ans.add(left);
            go(n, ans, lc+1, rc);
            ans.remove(ans.size()-1);
        }
        
        ans.add(right);
        go(n, ans, lc, rc+1);
        ans.remove(ans.size()-1);
        
    }
}
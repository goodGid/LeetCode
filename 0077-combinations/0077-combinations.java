class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), 1, n, k);
        return ans;
    }
    
    private void dfs(List<Integer> list, int stIdx, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=stIdx; i<=n; i++) {
            list.add(i);
            dfs(list,i+1, n,k);
            list.remove(list.size()-1);
        }
        
    }
}
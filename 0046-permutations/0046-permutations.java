class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(), nums);
        return ans;
    }
    
    private void dfs(List<Integer> list, int[] n) {
        if (list.size() == n.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=0; i<n.length; i++) {
            if (list.contains(n[i])) {
                continue;
            }
            
            list.add(n[i]);
            dfs(list, n);
            list.remove(list.size()-1);
        }
        
    }
}
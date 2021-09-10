class Solution {
    int target;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        target = t;
        dfs(candidates, 0, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] candidates, int idx, int sum, List<Integer> ca) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(ca));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            ca.add(candidates[i]);
            dfs(candidates, i, sum + candidates[i], ca);
            ca.remove(ca.size() - 1);
        }
    }
    
    public void print(List<Integer> ca) {
        for (Integer item : ca) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
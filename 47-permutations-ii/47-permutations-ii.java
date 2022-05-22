class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visit = new int[nums.length];
        recur(nums, new ArrayList<>());

        return new ArrayList<>(new LinkedHashSet<>(answer));
    }

    private void recur(int[] nums, List<Integer> ans) {
        if (ans.size() == nums.length) {
            answer.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            ans.add(val);
            recur(nums, ans);
            ans.remove(ans.size() - 1);
            visit[i] = 0;
        }
    }
}
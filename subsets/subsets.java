class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        solve(nums, ans, 0);
        return answer;

    }

    private void solve(int[] nums, List<Integer> ans, int idx) {

        if (idx == nums.length) {
            answer.add(new ArrayList<>(ans)); // [1]
            return;
        }

        ans.add(nums[idx]);
        solve(nums, ans, idx + 1);
        ans.remove(ans.size() - 1);

        solve(nums, ans, idx + 1);
    }

}
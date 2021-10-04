class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int size;

    public List<List<Integer>> subsets(int[] nums) {
        size = nums.length;
        go(nums, new ArrayList<>(), 0);
        return answer;
    }

    private void go(int[] nums, List<Integer> ans, int stIdx) {
        if (stIdx == size) {
            answer.add(new ArrayList(ans));
            return;
        }
        ans.add(nums[stIdx]);
        go(nums, ans, stIdx + 1);
        ans.remove(ans.size() - 1);
        go(nums, ans, stIdx + 1);
    }
}
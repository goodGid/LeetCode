     class Solution {

        private int[] visit;

        public List<List<Integer>> permute(int[] nums) {
            visit = new int[nums.length];

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            solve(ans, nums, list);
            return ans;
        }

        private void solve(List<List<Integer>> ans, int[] nums, List<Integer> list) {
            if (list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visit[i] == 1) {
                    continue;
                }

                list.add(nums[i]);
                visit[i] = 1;
                solve(ans, nums, list);
                list.remove(list.size() - 1);
                visit[i] = 0;

            }

        }
    }
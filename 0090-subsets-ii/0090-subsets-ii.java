class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 중복 제거를 위해 먼저 배열을 정렬합니다.

        Set<List<Integer>> set = new HashSet<>();
        dfs(0, nums, set, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        
        for (List<Integer> item : set) {
            ans.add(item);
        }
        
        return ans;
    }
    
    private void dfs(int idx, int[] nums, Set<List<Integer>> set, List<Integer> list) {
        if (idx == nums.length) {
            if (!set.contains(list)) {
                set.add(new ArrayList(list));
            }
            return;
        }
        
        list.add(nums[idx]);
        dfs(idx+1, nums, set, list);

        list.remove(list.size()-1);
        dfs(idx+1, nums, set, list);
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int size = nums.length;
        for (int i=0; i<size; i++) {
            map.put(nums[i], map.get(nums[i])-1);
            for (int j=i+1; j<size; j++) {
                map.put(nums[j], map.get(nums[j])-1);
                int target = -1 * (nums[i] + nums[j]);
                if (map.containsKey(target) && map.get(target) > 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    Collections.sort(list);
                    set.add(list);
                }
                map.put(nums[j], map.get(nums[j])+1);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        
        for (List<Integer> list : set) {
            ans.add(list);
        }
        
        return ans;
    }
}
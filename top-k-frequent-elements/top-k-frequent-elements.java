class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet()
                                                   .stream()
                                                   .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                                                   .collect(Collectors.toList());
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = collect.get(i).getKey();
        }

        return ans;
    }
}
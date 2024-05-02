class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        
        for (int i=0; i<n; i++) {
            int val = nums[i];
            if (val <= 0) {
                set.add(val);
            } else {
                if (set.contains(val *-1)) {
                    ans = val;
                }
            }
        }
        
        return ans;
    }
}
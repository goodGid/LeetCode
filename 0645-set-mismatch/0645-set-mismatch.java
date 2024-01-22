class Solution {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i=1; i<=size; i++) {
            set.add(i);
        }
        
        int[] ans = new int[2];
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                ans[0] = i;
            }
        }
        
        for (int i : set) {
            ans[1] = i;
        }
        
        return ans;
    }
}
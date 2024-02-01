class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length+1];
        for (int i : nums) {
            map[i]++;
        }
        int[] ans = new int[2];
        for (int i=1; i<nums.length+1; i++) {
            if (map[i] == 0) {
                ans[1] = i;
            }
            if (map[i] == 2) {
                ans[0] = i;
            }
        }
        
        return ans;
    }
}
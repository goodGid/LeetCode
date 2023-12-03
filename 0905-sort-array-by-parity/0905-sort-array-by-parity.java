class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> odds = new ArrayList<>();
        int size = nums.length;
        int[] ans = new int[size];
        int idx = 0;
        
        for (int i : nums) {
            odds.add(i);
        }
        
        for (int i=size-1; i>=0; i--) {
            if (nums[i] % 2 != 0) {
                continue;
            }           
            ans[idx++] = nums[i];
            odds.remove(i);
        }
        
        for (int i : odds) {
            ans[idx++] = i;
        }
        
        return ans;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int cur = 0;
        int ans = nums[0];
        
        for (int i : nums) {
            cur = i;
            if (sum + cur < 0) {
                ans = Math.max(ans, cur);
                sum = cur < 0 ? 0 : cur;
            } else {
                sum += cur;
                ans = Math.max(ans, sum);
            }
        }
        
        return ans;
    }
}
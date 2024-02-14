class Solution {
    public int[] rearrangeArray(int[] nums) {
        int odd = -1;
        int even = -1;
        int len = nums.length;
        
        for (int i=0; i<len; i++) {
            if (odd == -1 && nums[i] > 0) {
                odd = i;
            }
            if (even == -1 && nums[i] < 0) {
                even = i;
            }
        }
        
        int[] ans = new int[len];
        int idx = 0;
        
        while (idx < len) {
            ans[idx] = nums[odd];
            ans[idx+1] = nums[even];
            idx += 2;
            
            for (int i=odd+1; i<len; i++) {
                if (nums[i] > 0) {
                    odd = i;
                    break;
                }
            }
            
            for (int i=even+1; i<len; i++) {
                if (nums[i] < 0) {
                    even = i;
                    break;
                }
            }
        }   
        return ans;
    }
}
class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        if (n < 2) {
            return true;
        }
        
        int st = 1;
        
        boolean preDir = true;
        for (int i = st; i<n; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            preDir = nums[i] - nums[i-1] >= 0? true: false;
            st = i;
            break;
        }
               
        for (int i=st; i<n; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            boolean curDir = nums[i] - nums[i-1] >= 0? true: false;
            if (preDir != curDir) {
                return false;
            }
        }
        return true;
    }
}
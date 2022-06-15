class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length-1;
        int m = -1;
        boolean isFindVal = false;
        
        while (l <= r) {
            m = (l+r) / 2;
            if (nums[m] == target) {
                isFindVal = true;
                break;
            }
            
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        if (isFindVal == false) {
            return new int[] {-1, -1};
        }
        
        for (int i=m; i>=0; i--) {
            if (nums[i] == target) {
                l = i;
            }
        }
        
        for (int i=m; i<length;i ++) {
            if (nums[i] == target) {
                r = i;
            }
        }
        
        
        return new int[] {l,r};
    }
}
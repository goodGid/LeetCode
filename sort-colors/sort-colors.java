class Solution {
    public void sortColors(int[] nums) {
        int oneIdx = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                oneIdx = i;
                break;
            }
        }
        
        int l = 0;
        int r = nums.length-1;
        
        while (l <= r) {
            if (nums[l] == 0) {
                if (l > oneIdx) {
                    nums[l] = nums[oneIdx];
                    nums[oneIdx] = 0;
                    oneIdx++;
                }
                l++;
            } else if (nums[l] == 1) {
                if (oneIdx > l) {
                    oneIdx = l;
                }
                l++;
            } else if (nums[l] == 2) {
                nums[l] = nums[r];
                nums[r] = 2;
                r--;
            }
        }
    }
}
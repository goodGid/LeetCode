class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return ;
        }
        
        int toBeInsertIdx = 0;
        for (int i=0; i<nums.length; i++) {
            toBeInsertIdx = i;
            if (nums[i] ==0) {
                break;
            }
        }
        
        for (int i=toBeInsertIdx+1; i<nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[toBeInsertIdx++] = nums[i];
            nums[i] = 0;
        }
    }
}
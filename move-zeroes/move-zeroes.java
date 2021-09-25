class Solution {
    public void moveZeroes(int[] nums) {
        
        int willBeInsertIdx = 0;
        int zeroCnt = 0;
        int size = nums.length;
        
        for (int i=0; i<size; i++) {
            if (nums[i] != 0) {
                nums[willBeInsertIdx++] = nums[i];
            } else {
                zeroCnt++;
            }
        }
        
        for (int i=0; i<zeroCnt; i++) {
            nums[size-1-i] = 0;
        }
        
    
    }
}
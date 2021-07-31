class Solution {
    public int singleNumber(int[] nums) {
        int pivot = 0;
        
        for (int i=0; i<nums.length; i++){
            pivot ^= nums[i]; 
        }
        
        return pivot;
    }
}
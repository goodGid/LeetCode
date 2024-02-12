class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length / 2;
        
        if (nums.length % 2 == 0) {
            return nums[m-1];
        }
        return nums[m];       
    }
}
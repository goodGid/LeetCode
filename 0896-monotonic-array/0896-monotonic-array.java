// from Accepted Solutions Runtime Distribution
class Solution {
    public boolean isMonotonic(int[] nums) {

        int lowValue = nums[0];
        int highValue = nums[nums.length - 1];
        boolean increase = true;

        if (lowValue <= highValue) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i+1]) {
                    return false;
                }
            }
        }
        else {
           for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
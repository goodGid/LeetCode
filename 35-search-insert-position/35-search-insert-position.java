class Solution {
    public int searchInsert(int[] nums, int target) {

        int idx = Arrays.binarySearch(nums, target);

        if (idx >= 0) {
            return idx;
        }

        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
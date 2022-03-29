class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int pos = -1;

        int l = 0;
        int r = nums.length;
        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                pos = m;
                break;
            }

            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (pos == -1) {
            pos = l;
        }

        return pos;
    }
}
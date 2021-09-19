class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickselect(int[] nums, int left, int right, int target) {

        int l = left;
        int r = right;
        int pivot = nums[l + (r - l) / 2];

        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }

            while (l <= r && nums[r] > pivot) {
                r--;
            }

            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }

        if (target <= r) {
            return quickselect(nums, left, r, target);
        } else if (target >= l) {
            return quickselect(nums, l, right, target);
        }

        return nums[target];
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
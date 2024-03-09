class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    
    public int search(int[] nums, int l, int r, int target) {
        int mid = 0;
        
        while (l <= r) {
            mid = (l+r) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // 정렬 안되어있는 상태
                int leftRangeAns = search(nums, l, mid-1, target);
                int rightRangeAns = search(nums, mid+1, r, target);
                
                if (leftRangeAns != -1) {
                    return leftRangeAns;
                }
                if (rightRangeAns != -1) {
                    return rightRangeAns;
                }
                return -1;
            }
        }
        return -1;
    }
}
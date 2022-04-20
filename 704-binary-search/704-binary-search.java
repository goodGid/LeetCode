class Solution {
    public int search(int[] nums, int t) {
        int l = 0;
        int r = nums.length-1;
        
        int mid = - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            
            if (nums[mid] == t) {
                break;
            } else if (nums[mid] < t) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        
        return nums[mid] == t ? mid : -1 ;
    }
}
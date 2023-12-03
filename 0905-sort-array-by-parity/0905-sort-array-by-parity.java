// from Submit
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] % 2 != 0){
                if(nums[right] % 2 == 0){
                    swap(nums, left, right);
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
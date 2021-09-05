class Solution {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] ans = new int[length];
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        leftSum[0] = 1;
        rightSum[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            leftSum[i] = leftSum[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = leftSum[i] * rightSum[i];
        }
        return ans;
    }
}
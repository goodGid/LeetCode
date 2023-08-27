class Solution {
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int size = nums.length;
        
        int[] ans = new int[size];
        for (int i=0; i<size; i++) {
            ans[i] = -1;
        }
        
        for (int i=0; i<k*2 && i<size; i++) {
            sum += nums[i];
        }
        
        for (int i=k; i<size-k && i<size; i++) {
            sum += nums[i+k];
            ans[i] = (int) (sum / (k*2+1));
            sum -= nums[i-k];
        }
        
        return ans;
    }
}
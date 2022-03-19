class Solution {
    public int maxProduct(int[] nums) {
        int ans = -11;
        int max = 1;
        int min = 1;
        
        for (int i : nums) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(i, Math.max(tempMax*i, tempMin*i));
            min = Math.min(i, Math.min(tempMax*i, tempMin*i));            
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}
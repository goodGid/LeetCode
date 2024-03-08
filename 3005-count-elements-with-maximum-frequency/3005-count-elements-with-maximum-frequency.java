class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        
        int maxVal = -1;
        for (int i : nums) {
            arr[i]++;
            maxVal = Math.max(maxVal, arr[i]);
        }
        
        System.out.println(maxVal);
        
        int ans = 0;
        for (int i: nums) {
            if (arr[i] == maxVal) {
                ans += maxVal;
            }
        }
        
        return ans / maxVal;
    }
}
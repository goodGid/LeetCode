class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cntArray = new int[101];
        
        for (int i:nums) {
            cntArray[i]++;
        }
        
        int ans = 0;
        
        for (int i : cntArray) {
            if (i < 2) {
                continue;
            }
            
            ans = ans + ( i*(i-1) / 2);
        }
        
        return ans;
    }
}
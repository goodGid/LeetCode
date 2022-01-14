class Solution {
    public int maxArea(int[] h) {
        int ans = -1;
        
        int l = 0;
        int r = h.length - 1;
        
        while (l <= r) {
            if (h[l] <= h[r]) {
                ans = Math.max(ans, (r-l) * h[l]);
                l++;
            } else {
                ans = Math.max(ans, (r-l) * h[r]);
                r--;
            }
        }
        return ans;
    }
}
class Solution {
    public int search(int[] n, int target) {
        
        int l = 0;
        int r = n.length-1;
        int m;
        
        while (l <= r) {
            m = (l+r) / 2;
            
            if (n[m] == target) {
                return m;
            }
            
            if (n[l] <= n[m]) {
                if (n[l] <= target && target <= n[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (n[m] <= target && target <= n[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        
        return -1;
    }
}
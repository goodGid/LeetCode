class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        int m;
        boolean ans = false;
        
        while (l<=r) {
            m = l + (r-l) / 2;
            long sq = (long) m * m;
            if (num == sq) {
                ans = true;
                break;
            } else if (num < sq) {
                r = m - 1;
            } else { 
                l = m + 1;
            }
        }        
        return ans;
    }
}
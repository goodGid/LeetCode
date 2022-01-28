class Solution {
    public void sortColors(int[] n) {
        
        int l = 0;
        int r = n.length - 1;
        int cur = 0;
        
        while (cur <= r) {
            int value = n[cur];
            
            if (value == 0) {
                if ( cur == l ) {
                    l++;
                    cur++;
                } else { 
                    n[cur] = n[l];
                    n[l] = 0;
                    l++;
                }
            } else if (value == 1) {
                cur++;
            } else { 
                if (cur == r) {
                    r--;
                    cur++;
                } else {
                    n[cur] = n[r];
                    n[r] = 2;
                    r--;
                }
            }
        }
    }
}
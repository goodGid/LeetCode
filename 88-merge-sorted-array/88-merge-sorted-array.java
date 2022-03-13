class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx = m+n-1;
        
        while (true) {
            if (m ==0 && n == 0) {
                break;
            } else if (m == 0 ) {
                nums1[idx] = nums2[n-1];
                idx--;
                n--;
                continue;
            } else if (n == 0) {
                nums1[idx] = nums1[m-1];
                idx--;
                m--;
                continue;
            }
            
            if ( n-1 < 0 || nums1[m-1] >= nums2[n-1]) {
                nums1[idx] = nums1[m-1];
                idx--;
                m--;
            } else if (m-1 < 0 || nums1[m-1] < nums2[n-1]) {
                nums1[idx] = nums2[n-1];
                idx--;
                n--;
            }
        }
    }
}
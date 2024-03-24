class Solution {
    public int trap(int[] h) {
        int cnt = 0;
        int len = h.length;
        Stack<Integer> st = new Stack<>();
        
        int pivot = 0;
        for (int i=0; i<len; i++) {
            if (pivot <= h[i]) {
                while (!st.isEmpty()) {
                    int idx = st.pop();
                    // print(idx);
                    cnt += pivot - h[idx];
                    h[idx] = pivot;
                }
                pivot = h[i];
            } else {
                st.add(i);
            }
        }
        
        pivot = 0;
        st.clear();
        for (int i=len-1; i>=0; i--) {
            if (pivot <= h[i]) {
                while (!st.isEmpty()) {
                    int idx = st.pop();
                    // print(idx);
                    cnt += pivot - h[idx];
                    h[idx] = pivot;
                }
                pivot = h[i];
            } else {
                st.add(i);
            }
        }
        
        
        return cnt;
    }
    
    private void print(int i) {
        System.out.println(i);
    }
}
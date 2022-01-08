class Solution {
    public int[] replaceElements(int[] arr) {
        
        int size = arr.length;
        int[] ans = new int[size];
        ans[size-1] = -1;
        
        int max = arr[size-1];
        
        for(int i=size-2; i>=0; i--) {
            ans[i] = max;
            max = Math.max(max, arr[i]);
        }
        
        return ans;
    }
}
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        Arrays.sort(arr);
        int[] ans = new int[arr.length];
        ans[0] = 1;
        int idx = 0;
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < ans[idx]) {
                break;
            } else if (arr[i] == ans[idx]) {
                continue;
            }
            
            if (ans[idx] <= arr[i]) {
                if (ans[idx]+1 == arr[i]) {
                    ans[idx+1] = arr[i];
                } else {
                    ans[idx+1] = ans[idx] + 1;
                }
                idx++;
            } else {
                break;
            }
        }
        
        return ans[idx];
    }
    
    private void print(int val) {
        System.out.println(val);
    }
}
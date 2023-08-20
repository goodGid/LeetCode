class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int common = Math.abs(arr[1] - arr[0]);
        
        for (int i=2; i<arr.length; i++) {
            if (Math.abs(arr[i]- arr[i-1]) != common) {
                return false;
            }
        }
    
        return true;
    }
}
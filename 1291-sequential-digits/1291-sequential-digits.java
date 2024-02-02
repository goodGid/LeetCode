class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        int lowLength = getLength(low);
        int highLength = getLength(high);
        List<Integer> ans = new ArrayList<>();
        
        for (int digit=lowLength; digit<=highLength; digit++) {
            // System.out.println("digit : " + digit);
            for (int range=1; range<=10-digit; range++) {
                // System.out.println("range : " + range);
                int cnt = digit-1;
                int val = range;
                while (cnt-- > 0) {
                    int _temp = val % 10;
                    val *= 10;
                    val = val + (_temp+1);
                }
                
                if (low <= val && val <= high) {
                    ans.add(val);
                }
            }
        }
        return ans;
    }
    
    private int getLength(int val) {
        int cnt = 0;
        while (val > 0) {
            val /= 10;
            cnt++;
        }
        return cnt;
    }
}
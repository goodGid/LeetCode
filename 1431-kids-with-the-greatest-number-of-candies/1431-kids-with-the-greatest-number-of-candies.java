class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> ans = new ArrayList<>();
        int maxValue = 0;
        
        for (int i : candies) {
            maxValue = Math.max(maxValue, i);
        }

        for (int i : candies) {
            if (maxValue <= (i + extraCandies)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
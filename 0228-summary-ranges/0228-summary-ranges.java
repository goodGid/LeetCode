class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int lenght = nums.length;
        
        for (int i=0; i<lenght; i++) {
            int st=i;
            while (i+1 < lenght && nums[i+1]-nums[i]==1) {
                i++;
            }
            if (st == i) {
                ans.add(nums[st] + "");
            } else {
                ans.add(nums[st] + "->" + nums[i]);
            }
        }
        
        return ans;
    }
}
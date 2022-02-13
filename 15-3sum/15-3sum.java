class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            int target = nums[i] * -1;
            
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                
                if (sum < target) {
                    l = leftSkipDupValue(nums, l, r) + 1;
                } else if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l = leftSkipDupValue(nums, l, r) + 1;
                    r = rightSkipDupValue(nums, l, r) -1;
                } else {
                    r = rightSkipDupValue(nums, l, r) -1;
                }
            }
            
            while (i < nums.length - 1) {
                if (nums[i] == nums[i+1]) {
                    i++;
                } else {
                    break;
                }
            }
        }
        return ans;       
    }
    
    private int leftSkipDupValue(int[] nums, int st, int end) {
        while (st < end) {
            if (nums[st] == nums[st+1]) {
                st++;
            } else {
                break;
            }
        }
        return st;
    }
    
    private int rightSkipDupValue(int[] nums, int st, int end) {
        while (st < end) {
            if (nums[end] == nums[end-1]) {
                end--;
            } else {
                break;
            }
        }
        return end;
    }
}
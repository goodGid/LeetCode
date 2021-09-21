class Solution {
 
    int[] visit;
    
    public List<List<Integer>> permute(int[] nums) {
        visit = new int[nums.length];
        
        List<List<Integer>> ans = new ArrayList<>();
            
        go(nums, new ArrayList<>(), ans);
        return ans;
    }
    
    // ac = Answer Candidate 
    private void go(int[] nums, List<Integer> ac, List<List<Integer>> ans) {
        if (ac.size() == nums.length) {
            ans.add(new ArrayList(ac));            
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            
            visit[i] = 1;
            ac.add(nums[i]);
            go(nums,ac,ans);
            ac.remove(ac.size()-1);
            visit[i] = 0;
        }
    }
}
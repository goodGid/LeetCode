class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);      
        int size = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<size-2; i++) {
            List<Integer> _list = new ArrayList<>();
            if (nums[i+2] - nums[i] <= k) {
                _list.add(nums[i]);
                _list.add(nums[i+1]);
                _list.add(nums[i+2]);
                i = i+2;
            } else {
                System.out.println(i);
                return new int[0][0];
            }
            list.add(_list);
        }
        
        int ansSize = list.size();
        int[][] ans = new int[ansSize][3];
        
        for (int i=0; i<ansSize; i++) {
            int idx = 0;
            for (Integer val : list.get(i)) {
                ans[i][idx++] = val;
            }
        }
        return ans;
    }
}
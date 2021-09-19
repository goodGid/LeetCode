class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }
        return ans;
    }
}
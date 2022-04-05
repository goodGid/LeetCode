// 220406 
// 다른 사람 풀이 기록을 위한 제출 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        int left = 0;
        int right = 0;

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        while (right < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[right]) {
                q.removeLast();
            }
            q.addLast(right);
            right++;

            if (right - left == k) {
                if (right - q.peekFirst() > k) {
                    q.removeFirst();
                }
                res[index++] = nums[q.peekFirst()];
                left++;
            }
        }
        return res;
    }
}

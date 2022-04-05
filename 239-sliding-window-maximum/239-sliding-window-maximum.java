class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.getVal() - o1.getVal());

        for (int i = 0; i < k - 1; i++) {
            pq.add(new Node(i, nums[i]));
        }

        int l = -1;
        int[] ans = new int[nums.length - k + 1];

        for (int r = k - 1; r < nums.length; r++) {
            l++;
            pq.add(new Node(r, nums[r]));

            while (pq.peek().getIdx() < l) {
                pq.poll();
            }
            ans[l] = pq.peek().getVal();
        }
        return ans;
    }
}

class Node {
    int idx;
    int val;

    public int getVal() {
        return val;
    }

    public int getIdx() {
        return idx;
    }

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
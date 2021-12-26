// ref : https://silvergoni.tistory.com/entry/leetcode-437-Path-Sum-III

class Solution {
    private int count = 0;
    private int targetSum = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        targetSum = sum;
        solve(root, 0);
        return count;
    }

    private void solve(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        if (currentSum == targetSum) {
            count++;
        }

        count += map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        solve(root.left, currentSum);
        solve(root.right, currentSum);
        map.put(currentSum, map.get(currentSum) - 1);
    }
}
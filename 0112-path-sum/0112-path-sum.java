class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int targetSum) {
        if (node == null) { // base case
            return false;
        }

        targetSum -= node.val;

        // check whether it's a leaf node
        if (node.left == null && node.right == null) {
            return targetSum == 0;
        }

        return dfs(node.left, targetSum) || dfs(node.right, targetSum);
    }
}


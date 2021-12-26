class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        return initiate(root, targetSum)
    }

    private fun initiate(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0
        return fromNodePathSum(root, targetSum) + initiate(root.left, targetSum) + initiate(root.right, targetSum)
    }

    private fun fromNodePathSum(node: TreeNode?, targetSum: Int): Int {
        if (node == null) return 0
        val me = if (node.`val` == targetSum) 1 else 0
        val left = fromNodePathSum(node.left, targetSum - node.`val`)
        val right = fromNodePathSum(node.right, targetSum - node.`val`)
        return me + left + right
    }
}
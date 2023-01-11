/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private final String LEFT = "(";
    private final String RIGHT = ")";

    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(root.val));

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        if (leftNode != null && rightNode != null) {
            sb.append(LEFT);
            sb.append(tree2str(leftNode));
            sb.append(RIGHT);
            sb.append(LEFT);
            sb.append(tree2str(rightNode));
            sb.append(RIGHT);
        } else if (leftNode != null && rightNode == null) {
            sb.append(LEFT);
            sb.append(tree2str(leftNode));
            sb.append(RIGHT);
        } else if (leftNode == null && rightNode != null) {
            sb.append(LEFT);
            sb.append(RIGHT);
            sb.append(LEFT);
            sb.append(tree2str(rightNode));
            sb.append(RIGHT);
        } else if (leftNode == null && rightNode == null) {
            // Nothing
        }

        return sb.toString();
    }
}
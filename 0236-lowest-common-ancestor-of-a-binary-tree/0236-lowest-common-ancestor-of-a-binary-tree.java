/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
    // private int cnt = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        go(root, p, q);
        return ans;
    }
    
    private int go(TreeNode node, TreeNode p, TreeNode q) {
        int cnt = 0;
        
        if (node == null) {
            return 0;
        }
        if (ans != null) {
            return -1;
        }
        
        if (node.val == p.val || node.val == q.val) {
            cnt++;
        }
        
        cnt += go(node.left, p, q);
        cnt += go(node.right, p, q);
        if (cnt == 2) { 
            ans = node;
            cnt = 0;
        }
        return cnt;
    }

}
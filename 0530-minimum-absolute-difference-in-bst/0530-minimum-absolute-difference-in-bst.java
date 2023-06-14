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
    
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        
        Collections.sort(list);
        int ans = 100001;
        for (int i=1; i<list.size(); i++) {
            ans = Math.min(ans, list.get(i) - list.get(i-1));
        }
        
        return ans; 
    }
    
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
        
    }
}
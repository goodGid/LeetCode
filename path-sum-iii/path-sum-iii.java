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
    int target;
    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;        
        go(new ArrayList<>(), root);
        return ans;
    }
    
    private void go(List<Integer> list, TreeNode node) {
        if (node == null) {
            return ;
        }
        
        for (int i=0; i<list.size(); i++) {
            if ( target == list.get(i) + node.val ) {
                ans++;
            }
        }
        if (target == node.val) {
            ans++;
        }
        
        List<Integer> newList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            newList.add(list.get(i) + node.val);
        }
        newList.add(node.val);
        
        go(newList, node.left);
        go(newList, node.right);
    }
}
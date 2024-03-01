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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean isOdd = false;
        while (!q.isEmpty()) {
            isOdd = !isOdd;
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            
            int listSize = list.size();
            
            if (isOdd) {
                for (int i=0; i<listSize; i++) {
                    if (list.get(i) % 2 == 0) {
                        return false;
                    }
                }
                for (int i=0; i<listSize-1; i++) {
                    if (list.get(i) >= list.get(i+1)) {
                        return false;
                    }
                }
            } else {
                for (int i=0; i<listSize; i++) {
                    if (list.get(i) % 2 == 1) {
                        return false;
                    }
                }
                for (int i=0; i<listSize-1; i++) {
                    if (list.get(i) <= list.get(i+1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// ref : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37520/Simple-recursive-Java-solution-O(1)-space-O(n)-time
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        link(root.left, root.right);
        return root;
    }

    public void link(Node left, Node right) {
        if (left == null && right == null) {
            return;
        }
        left.next = right;
        link(left.left, left.right);
        link(left.right, right.left);
        link(right.left, right.right);
    }
}
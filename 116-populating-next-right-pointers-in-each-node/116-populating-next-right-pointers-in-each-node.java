// ref : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/962728/Java-0ms-with-visual-explanation
class Solution {
    public Node connect(Node root) {
        if (root == null) {return null;}
        if (root.left != null) {root.left.next = root.right;}
        if (root.right != null && root.next != null) {root.right.next = root.next.left;}
        connect(root.left);
        connect(root.right);
        return root;
    }
}
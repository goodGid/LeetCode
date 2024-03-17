// ref : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/4472121/Use-Queue-and-StringBuilder

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        var result = build(new StringBuilder(), queue);
        //System.out.println("result" + result);
        return result;
    }

    private String build(StringBuilder str, Queue<TreeNode> queue) {

        if(queue.isEmpty()) {
            return str.toString();
        }
        var node = queue.poll();
        if(node == null) {
             str.append("-_");
        } else {
             str.append(node.val).append("_");
             queue.offer(node.left);
             queue.offer(node.right);
        }
        return build(str, queue);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] arr = data.split("_");
        var root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int index = 0;
        while(!queue.isEmpty()) {
            var node = queue.poll();

            if(!arr[++index].equals("-")) {
                var left = new TreeNode(Integer.valueOf(arr[index]));
                node.left = left;
                queue.offer(left);
            }
            if(!arr[++index].equals("-")) {
                var right = new TreeNode(Integer.valueOf(arr[index]));
                node.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
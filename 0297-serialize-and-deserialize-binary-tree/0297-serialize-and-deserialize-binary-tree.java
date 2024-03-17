class Codec {
    private static final String DELIMETER = "_";
    private static final String NULL = "x";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(DELIMETER);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (Objects.nonNull(node.left)) {
                q.add(node.left);
                sb.append(node.left.val).append(DELIMETER);
            } else {
                sb.append(NULL).append(DELIMETER);
            }

            if (Objects.nonNull(node.right)) {
                q.add(node.right);
                sb.append(node.right.val).append(DELIMETER);
            } else {
                sb.append(NULL).append(DELIMETER);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] splits = data.split(DELIMETER);

        List<String> lists = new ArrayList<>();
        for (String s : splits) {
            if (s.equals(DELIMETER)) {
                continue;
            }
            lists.add(s);
        }

        if (lists.isEmpty()) {
            return null;
        }
        if (lists.get(0).equals(NULL)) {
            return null;
        }
        
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(lists.get(idx++)));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (idx < lists.size()) {
            TreeNode node = q.poll();

            String val = lists.get(idx++);
            if (!val.equals(NULL)) {
                node.left = new TreeNode(Integer.valueOf(val));
                q.add(node.left);
            }

            val = lists.get(idx++);
            if (!val.equals(NULL)) {
                node.right = new TreeNode(Integer.valueOf(val));
                q.add(node.right);
            }
        }
        return root;
    }
}
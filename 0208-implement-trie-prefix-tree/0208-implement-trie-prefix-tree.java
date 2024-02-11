class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int size = word.length();
        char[] cs = word.toCharArray();

        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(String.valueOf(c));
            String key = sb.toString();
            if (node.subs.containsKey(key)) {
                node = node.subs.get(key);
            } else {
                Node newNode = new Node();
                node.subs.put(key, newNode);
                node = newNode;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        int size = word.length();
        char[] cs = word.toCharArray();

        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(String.valueOf(c));
            String key = sb.toString();
            if (node.subs.containsKey(key)) {
                node = node.subs.get(key);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String word) {
        int size = word.length();
        char[] cs = word.toCharArray();

        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(String.valueOf(c));
            String key = sb.toString();
            if (node.subs.containsKey(key)) {
                node = node.subs.get(key);
            } else {
                return false;
            }
        }
        return true;
    }

    private class Node {
        Map<String, Node> subs;
        boolean isEnd;

        public Node() {
            this.subs = new HashMap<>();
            this.isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
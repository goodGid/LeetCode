class Trie {
    HashMap<String, Boolean> map;
    HashMap<String, Boolean> subMap;

    public Trie() {
        map = new HashMap<>();
        subMap = new HashMap<>();
    }
    
    public void insert(String word) {
        map.put(word, true);
        for (int i=0; i<word.length(); i++) {
            subMap.put(word.substring(0,word.length()-i), true);
        }
    }
    
    public boolean search(String word) {
        return map.getOrDefault(word, false);
    }

    public boolean startsWith(String prefix) {
        return subMap.getOrDefault(prefix, false);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
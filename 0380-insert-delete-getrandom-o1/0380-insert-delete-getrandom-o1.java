class RandomizedSet {
    private Set<Integer> set;
    private List<Integer> list;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new LinkedList<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            int idx = list.indexOf(val);
            list.remove(idx);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = list.size();
        double dValue = Math.random();
        int iValue = (int)(dValue * size);
        return list.get(iValue);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
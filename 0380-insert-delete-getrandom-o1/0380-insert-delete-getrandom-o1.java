class RandomizedSet {
    private HashSet<Integer> set;
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
            list.remove(list.indexOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(Math.abs(random.nextInt() % list.size()));
    }
}
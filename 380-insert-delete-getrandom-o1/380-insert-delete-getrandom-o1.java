class RandomizedSet {
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Iterator<Integer> iterator = set.iterator();
        Random ran = new Random();
        int randomInt = ran.nextInt(set.size());

        for (int i = 0; i < randomInt; i++) {
            iterator.next();
        }
        return iterator.next();
    }
}
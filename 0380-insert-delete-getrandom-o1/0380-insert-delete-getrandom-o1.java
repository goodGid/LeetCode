class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private int size;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size++);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
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
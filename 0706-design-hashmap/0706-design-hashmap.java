// ref : Accepted Solutions Runtime Distribution
class MyHashMap {
    int[] mapArr;

    public MyHashMap() {
        mapArr = new int[1000001];
        Arrays.fill(mapArr, -1);
    }

    public void put(int key, int value) {
        mapArr[key] = value;
    }

    public int get(int key) {
        return mapArr[key];
    }

    public void remove(int key) {
        mapArr[key] = -1;
    }
}
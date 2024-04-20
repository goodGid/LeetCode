// from : https://leetcode.com/problems/time-based-key-value-store/discuss/2667517/Java-or-TreeSet-(Sorted-Set)-or-Faster-than-91.76
class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tm=map.getOrDefault(key, new TreeMap<>());
        tm.put(timestamp, value);
        map.put(key, tm);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> tm=map.get(key);
        Map.Entry<Integer, String> e=tm.floorEntry(timestamp);
        if(e==null) return "";
        else return e.getValue();
    }
}

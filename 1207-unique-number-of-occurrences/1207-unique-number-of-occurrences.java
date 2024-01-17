class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int[] val = new int[2002];
        
        for (int i: arr) {
            i += 1000;
            val[i]++;
            set.add(i);
        }
        
        int[] check = new int[2002];
        
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (check[val[value]] != 0) {
                return false;
            }
            check[val[value]] = 1;
        }
        return true;
    }
}
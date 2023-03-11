class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();

        for (int item : people) {
            list.add(item);
        }
        Collections.sort(list);

        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int maxVal = list.get(j);
            int minVal = list.get(i);

            if (maxVal + minVal <= limit) {
                i++;
            }
            j--;
            ans++;
        }
        return ans;
    }
}
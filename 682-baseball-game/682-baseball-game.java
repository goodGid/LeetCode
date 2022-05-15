class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();

        int length = ops.length;
        for (int i = 0; i < length; i++) {
            int size = list.size();
            char[] chars = ops[i].toCharArray();
            char first = chars[0];

            switch (first) {
                case 'C':
                    list.remove(size - 1);
                    break;
                case 'D':
                    list.add(list.get(size - 1) * 2);
                    break;
                case '+':
                    int sum = list.get(size - 1) + list.get(size - 2);
                    list.add(sum);
                    break;
                default:
                    list.add(Integer.parseInt(ops[i]));
                    break;
            }
        }

        int ans = 0;
        for (int i : list) {
            ans += i;
        }
        return ans;
    }
}
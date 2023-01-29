class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);

            List<String> subAns = new ArrayList<>();
            for (String p : products) {
                if (p.startsWith(substring)) {
                    subAns.add(p);
                }
                if (subAns.size() >= 3) {
                    break;
                }
            }
            ans.add(subAns);
        }

        return ans;
    }
}
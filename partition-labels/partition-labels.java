class Solution {
    public List<Integer> partitionLabels(String s) {
        int size = s.length();
        List<Integer> answerList = new ArrayList<>();
        int[] alphaArray = new int[26];
        Arrays.fill(alphaArray, -1);

        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            alphaArray[charArray[i] - 'a'] = i;
        }

        int highIndex = -1;
        int stIndex = 0;

        for (int i = 0; i < size; i++) {
            if (alphaArray[charArray[i] - 'a'] > highIndex) {
                highIndex = alphaArray[charArray[i] - 'a'];
            }

            if (i == highIndex) {
                answerList.add(i - stIndex + 1);
                stIndex = i + 1;
            }
        }

        return answerList;
    }
}
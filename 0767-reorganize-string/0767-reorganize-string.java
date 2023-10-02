// ref : 정답 코드 중 Runtime 효율 1위 블록 참고
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26]; //to Store Frequency of each alphabet
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {  //store the frequency
            freq[arr[i] - 'a']++;
        }

        int max = 0, letter = 0;
        for (int i = 0; i < 26; i++) {  //find the max frequency
            if (freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return ""; //if max is more than half then not possible
        }

        int idx = 0;
        char[] res = new char[s.length()];

        while (freq[letter] > 0) {   //distribute the max freq char into even indices
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1; //all even indices filled, so switch to odd indices
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        return String.valueOf(res);
    }
}
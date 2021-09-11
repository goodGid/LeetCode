class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ansList = new ArrayList<>();
        boolean[] visit = new boolean[26];
        int[] dp = new int[26];
        
        char[] charArray = s.toCharArray();
        int size = charArray.length;
        for (int i=0; i<size; i++) {
            dp[charArray[i] - 'a']++;
        }
        
        int length = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<size; i++) {
            int idx = charArray[i] - 'a';
            
            if (dp[idx] != 0 && visit[idx] == false)  {
                visit[idx] = true;
                length += dp[idx];
            }
            
            sb.append(charArray[i]);
            length--;
            
            if (length == 0 ) {
                ansList.add(sb.toString().length());
                sb = new StringBuilder();
            }            
        }
        
        return ansList;
        
    }
}
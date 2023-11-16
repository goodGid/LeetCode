class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] charArray = arr[i].toCharArray();
            int size = arr[i].length();
            for (int idx = size - 1; idx >= 0; idx--) {
                sb.append(charArray[idx]);
            }
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
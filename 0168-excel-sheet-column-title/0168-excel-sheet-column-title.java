/*
ref : Solution
230822 
1시간을 잡고 풀었는데 못풀었다.
너무 현타가 쎄게 오네... -ㅂ-
내가 풀었는데 틀렸던 코드 : https://leetcode.com/submissions/detail/1028663915
*/

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber--;
            // Get the last character and append it at the end of the string.
            ans.append((char)((columnNumber) % 26 + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        
        // Reverse it, as we appended characters in reverse order.
        return ans.reverse().toString();
    }
}
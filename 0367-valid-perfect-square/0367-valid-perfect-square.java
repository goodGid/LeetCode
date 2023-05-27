// from : https://leetcode.com/problems/valid-perfect-square/discuss/3333620/Java-Detailed-Explaination-with-Full-trace-for-both-perfect-and-non-perfect-square-beats-100

class Solution {
    public boolean isPerfectSquare(int num) {
        int i=1;
        while(num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }
}
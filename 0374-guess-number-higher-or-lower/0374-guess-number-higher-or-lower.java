/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int m;
        
        int ans = 0;
        while (l <= r) {
            m =l+(r-l)/2;
            int result = guess(m);
            if (result == -1 ) {
                r = m-1;
            } else if ( result == 1) {
                l = m+1;
            } else {
                ans = m;
                break;
            }
        }
        
        return ans;
    }
}

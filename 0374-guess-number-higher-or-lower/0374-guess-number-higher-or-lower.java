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
        int right = n;
        int left = 0;
        int mid = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(guess(mid)==0)
                break;
            else if(guess(mid)==-1)
                right=mid-1;
            else 
                left=mid+1;
        }
        return mid;
    }
}
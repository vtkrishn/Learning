/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = start + (end - start)/2;
            int guess = guess(mid);
            if(guess == 0)
                return mid;
            else if(guess < 0)
                end = mid-1;
            else
                start = mid + 1;
        }
        return -1;
    }
}

import java.util.*;

public class Solution {
    public static boolean canWin(int leap, int[] game) {
        //return canWin(leap, game, 0);
        return canWinDP(leap, game);
    }

    public static boolean canWinDP(int leap, int[] game) {
        //initialize dp array
        int[] dp = new int[game.length];
        //start from index 1
        for(int i=1;i<game.length;i++){
            //if the previous index is 1 then return false
            if(game[i-1] == 1)
                return false;
            //if the previous index is 0 and previous index + leap > array length then return true
            if(game[i-1] == 0 && (i-1 + leap) > game.length)
                return true;

            //if the current index is 1 then look for previous result + leap
            if(game[i] == 1)
                dp[i] = dp[i-1]+leap;
            //if the current index is 0 then look for max of both the options
            if(game[i] == 0)
                dp[i] = Math.max(i+1, i+leap);
        }
        //check if the element stored at the last index is greater than the array length
        return dp[game.length] > game.length;
    }
    public static boolean canWin(int leap, int[] game, int index) {
        if(index < 0 || game[index] == 1)
            return false;
        if(index > game.length-1 || index+leap > game.length-1)
            return true;
        game[index] = 1;

        return canWin(leap, game, index-1) || canWin(leap, game, index+1) || canWin(leap, game, index+leap);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

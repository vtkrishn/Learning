import java.util.Arrays;
public class CoinsRecursion {
    public static void main(String[] args) {
        //int[] coins = {2,3,7};
        int[] coins = {3,5,10};
        System.out.println(makeChanges(coins, 13, 0));
    }
    
        public static int makeChanges(int[] coins,int money, int index){
          if(money == 0)
            return 1;
          if(index == coins.length)  
            return 0;
          int amount = 0;
          int ways = 0;
          while(amount <= money){
            int remaining = money - amount;
            ways += makeChanges(coins, remaining, index + 1);
            amount+= coins[index];
          }
          return ways;
        }
}
package javaproject.dynamic;

public class Coins {
    public static void main(String[] args) {
      int[] coins = {1,2,5};
      int amount = 5;
      int result = compute(coins, amount,amount);
      System.out.println(result);
    }
    
    public static int compute(int[] coins, int amount,int sum){
        if(sum <= 0)
            return 1;
        return compute(coins,amount, sum - coins[0]) + compute(coins, amount, sum - coins[1]) + compute(coins,amount,sum - coins[2]);
    }

}

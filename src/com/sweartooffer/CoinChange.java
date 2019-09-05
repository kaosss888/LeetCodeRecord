package com.sweartooffer;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount];
        return change(coins, amount, table);
    }

    public int change(int[] coins, int amount, int[] table) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (table[amount] != 0)
            return table[amount];

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < coins.length; i++) {

            result = Math.min(change(coins, amount - coins[i], table), result);

        }

        table[amount] = result + 1;

        return table[amount];
    }
}

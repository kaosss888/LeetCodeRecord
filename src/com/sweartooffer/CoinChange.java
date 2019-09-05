package com.sweartooffer;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        return change(coins, amount, table);
    }

    public int change(int[] coins, int amount, int[] table) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (table[amount] != 0)
            return table[amount];

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int subResult = change(coins, amount - coins[i], table);
            if (subResult == -1)
                continue;
            result = Math.min(result, subResult + 1);
        }

        table[amount] = result == Integer.MAX_VALUE ? -1 : result;

        return table[amount];
    }
}

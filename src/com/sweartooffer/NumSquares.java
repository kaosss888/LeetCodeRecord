package com.sweartooffer;

import java.util.HashMap;
import java.util.Map;

public class NumSquares {

    public Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        if (n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);

        int num = (int) Math.floor(Math.sqrt(n));

        if (num * num == n) {
            map.put(n, 1);
            return 1;
        }

        int temp;
        int result = Integer.MAX_VALUE;
        for (int i = num; i >= 1; i--) {
            temp = numSquares(n - i * i) + 1;

            result = Math.min(result, temp);

        }
        map.put(n, result);

        return result;

    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
    }
}

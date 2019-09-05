package com.sweartooffer;

public class MaxProduct {

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, min = 1;
        int result = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                max = max ^ min;
                min = max ^ min;
                max = max ^ min;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.max(min * nums[i], nums[i]);

            result = Math.max(max, result);
        }

        return result;
    }
}

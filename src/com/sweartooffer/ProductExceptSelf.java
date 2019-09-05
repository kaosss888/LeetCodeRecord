package com.sweartooffer;

/**
 * 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            output[j] *= k;
            k *= nums[j];
        }

        return output;
    }
}

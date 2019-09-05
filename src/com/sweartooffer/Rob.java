package com.sweartooffer;

public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] table = new int[nums.length + 1];

        table[0] = 0;
        table[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {

            table[i] = Math.max(table[i - 2] + nums[i - 1], table[i - 1]);
        }

        return table[nums.length - 1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{2,1,1,2}));
    }
}

package com.sweartooffer;

/**
 * 旋转数组
 * 1、环状循环 (*)
 * 2、反转
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        int count = 0;
        for (int i = 0; count < length; i++) {
            int index = i;
            int cur = nums[index];
            int tmp;
            do {
                int next = (index + k) % length;
                tmp = nums[next];
                nums[next] = cur;
                cur = tmp;
                index = next;
                count++;
            } while (index != i);
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

}

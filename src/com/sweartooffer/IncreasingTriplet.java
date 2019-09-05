package com.sweartooffer;

/**
 * 递增的三元子序列
 */
public class IncreasingTriplet {

    public static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int minVal = Integer.MAX_VALUE, midVal = Integer.MAX_VALUE;

        for (int v : nums) {
            if (v <= minVal) {
                minVal = v;
            } else if (v <= midVal) {
                midVal = v;
            } else  {
                return true;
            }
        }

        return false;
    }
}

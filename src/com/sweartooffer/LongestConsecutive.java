package com.sweartooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 问题的关键在于找到序列的开始
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int result = 0;

        for (int i : nums) {
            set.add(i);
        }

        for (int num : nums) {

            if (!set.contains(num - 1)) {

                int currentNum = num;
                int tempResult = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    tempResult++;
                }

                result = Math.max(tempResult, result);
            }
        }

        return result;
    }
}

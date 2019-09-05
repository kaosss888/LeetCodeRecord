package com.sweartooffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[]{};
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        if (k == nums.length)
            return new int[]{queue.poll()};

        list.add(queue.peek());
        for (int j = k; j < nums.length; j++) {
            if (nums[j] >= queue.peek())
                list.add(nums[j]);
            else
                list.add(queue.peek());
            queue.poll();
            queue.add(nums[j]);
        }

        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

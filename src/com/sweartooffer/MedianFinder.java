package com.sweartooffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class MedianFinder {

    PriorityQueue<Integer> lowHeap;
    PriorityQueue<Integer> highHeap;

    public MedianFinder() {
        lowHeap = new PriorityQueue<>();
        highHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        lowHeap.add(num);
        highHeap.add(lowHeap.peek());
        lowHeap.poll();

        if (lowHeap.size() < highHeap.size()) {
            lowHeap.add(highHeap.peek());
            highHeap.poll();
        }

    }

    public double findMedian() {
        return (double) lowHeap.size() > highHeap.size() ? lowHeap.peek() : (lowHeap.peek() + highHeap.peek()) * 0.5;
    }
}

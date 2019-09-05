package com.sweartooffer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int i : map.keySet()) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

//        queue.forEach(integerIntegerEntry -> System.out.println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue()));

        queue.forEach(list::add);

//        queue.stream().map(Map.Entry::getKey).peek(list::add).collect(Collectors.toList());

        return list;
    }

//    public static void main(String[] args) {
//        TopKFrequent topKFrequent = new TopKFrequent();
//        int[] nums = new int[]{1,1,1,2,2,3};
//        List<Integer> list = topKFrequent.topKFrequent(nums, 2);
//
//        for (int l : list) {
//            System.out.println(l);
//        }
//    }
}

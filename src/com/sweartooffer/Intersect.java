package com.sweartooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        for (int k : nums2) {
            if (map.containsKey(k) && map.get(k) > 0) {
                list.add(k);
                map.put(k, map.get(k) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

//    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2,2};
//        int[] res = intersect(nums1, nums2);
//
//        StringBuilder sb = new StringBuilder("[");
//        for (int i = 0; i < res.length; i++) {
//            if (i == res.length - 1) {
//                sb.append(res[i] +"]");
//            } else {
//                sb.append(res[i] + ",");
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
}

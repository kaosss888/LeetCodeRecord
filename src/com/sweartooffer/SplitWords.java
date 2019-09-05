package com.sweartooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWords {

    static Map<Character, List<String>> cache = new HashMap<>();

    public static boolean wordBreak(String s, int index) {

        if (s.equals("") || null == s) {
            return false;
        }

        if (index == s.length()) {
            return true;
        }

        if (cache.containsKey(s.charAt(index))) {
            for (String s1 : cache.get(s.charAt(index))) {
                if (s.substring(index, index + s1.length()).equals(s1)) {
                    if (wordBreak(s, index + s1.length())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        return false;
    }

//    public static void main(String[] args) {
//        String s = "a";
//        String[] wordDict = {"a"};
//        List<String> strings = new ArrayList<>();
//        for (String item : wordDict) {
//            strings.add(item);
//        }
//        buildMapCache(strings);
//        if (wordBreak(s, 0)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
////        for (Map.Entry<Character, List<String>> entry : cache.entrySet()) {
////            System.out.println(entry.getKey() + ":");
////            for (String v : entry.getValue()) {
////                System.out.println(" " + v);
////            }
////        }
//
//    }

    private static void buildMapCache(List<String> wordDict) {

        for (String s : wordDict) {
            char c = s.charAt(0);
            cache.computeIfAbsent(c, k -> new ArrayList<>());
            cache.get(c).add(s);
        }
    }
}

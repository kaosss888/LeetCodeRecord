package com.sweartooffer;

import java.util.*;

public class SpitWordsPlus {

    public HashMap<Integer, List<String>> result = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> strings = new HashSet<>(wordDict);
        return split(s, strings, 0);
    }


    public List<String> split(String s, Set<String> wordSets, int start) {
        if (result.containsKey(start)) {
            return result.get(start);
        }

        List<String> list = new ArrayList<>();

        if (start == s.length()) {
            list.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSets.contains(s.substring(start, end))) {
                List<String> strings = split(s, wordSets, end);
                for (String i : strings) {
                    list.add(s.substring(start, end) + (i.equals("") ? "" : " ") + i);
                }
            }
        }

        result.put(start, list);
        return list;
    }
}

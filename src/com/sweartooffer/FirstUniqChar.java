package com.sweartooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中第一个唯一字符
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {

        Set<Character> repeat = new HashSet<>();

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (repeat.contains(cur))
                continue;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    repeat.add(s.charAt(i));
                    break;
                }
            }
            if (!repeat.contains(s.charAt(i))) {
                index = i;
                break;
            }
        }
        return index;
    }
}

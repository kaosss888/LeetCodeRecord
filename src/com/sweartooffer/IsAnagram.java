package com.sweartooffer;

import java.util.Arrays;

/**
 * 有效的字母异位词
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        String s1 = new String(sChars);
        String s2 = new String(tChars);

        return s1.equals(s2);
    }
}
